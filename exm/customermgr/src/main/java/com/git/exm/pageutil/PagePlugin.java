package com.git.exm.pageutil;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import static com.sun.jmx.snmp.ServiceName.DELEGATE;

@Intercepts(@Signature(type= StatementHandler.class,method = "prepare",args={Connection.class}))
public class PagePlugin extends BaseInterceptor implements Interceptor {

    private static String dialect = "";
    private static String pageSqlId = "";

    public Object intercept(Invocation ivk) throws Throwable {
        if(ivk.getTarget() instanceof RoutingStatementHandler){
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) Reflections.getFieldValue(statementHandler, DELEGATE);
            MappedStatement mapperStatement =(MappedStatement) Reflections.getFieldValue(delegate, MAPPED_STATEMENT);
            if(mapperStatement.getId().matches(pageSqlId)){
                BoundSql boundSql = delegate.getBoundSql();
                Object parameterObject = boundSql.getParameterObject();
                if(parameterObject == null){
                    throw new NullPointerException("parameter is null");
                }else{
                    Connection connection = (Connection)ivk.getArgs()[0];
                    String sql = boundSql.getSql();
                    String countSql = "select count(0) from ("+sql+") as tmp_count";
                    PreparedStatement countStmt = connection.prepareStatement(countSql);
                    BoundSql countBS = new BoundSql(mapperStatement.getConfiguration(),countSql,boundSql.getParameterMappings(),parameterObject);
                    SQLHelper.setParameters(countStmt,mapperStatement,countBS,parameterObject);
                    ResultSet rs = countStmt.executeQuery();
                    int count = 0;
                    if(rs.next()){
                        count = rs.getInt(1);
                    }
                    rs.close();
                    countStmt.close();

                    Page page =  null;
                    if(parameterObject instanceof Page){
                        page = (Page) parameterObject;
                        page.setTotalcCount(count);
                    }else{
                        return Reflections.getFieldValue(parameterObject,"page");
                    }

                    String pagingSql = SQLHelper.generatePageSql(sql, page, null);//DIALECT
                    if (log.isDebugEnabled()) {
                        log.debug("PAGE SQL:" + pagingSql);
                    }
                    //将分页sql语句反射回BoundSql.
                    Reflections.setFieldValue(boundSql, "sql", pagingSql);
                }
            }
        }
        return null;
    }

    public Object plugin(Object o) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
