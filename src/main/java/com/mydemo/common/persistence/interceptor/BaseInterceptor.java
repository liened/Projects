package com.mydemo.common.persistence.interceptor;

import com.mydemo.common.config.Global;
import com.mydemo.common.persistence.Page;
import com.mydemo.common.persistence.dialect.Dialect;
import com.mydemo.common.persistence.dialect.db.MySQLDialect;
import com.mydemo.common.util.Reflections;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;

import java.io.Serializable;
import java.util.Properties;

/**
 * Mybatis分页拦截器基类
 */
public abstract class BaseInterceptor implements Interceptor,Serializable{

    protected static final String PAGE = "page";

    protected static final String DELEGATE = "delegate";

    protected static final String MAPPED_STATEMENT = "mappedStatement";

    protected Dialect DIALECT;
    protected Log log = LogFactory.getLog(this.getClass());
    /**
     * 对参数进行转换和检查
     * @param parameterObject 参数对象
     * @param page            分页对象
     * @return 分页对象
     * @throws NoSuchFieldException 无法找到参数
     */
    protected static Page<Object> convertParameter(Object parameterObject, Page<Object> page){
        try {
            if (parameterObject instanceof Page){
                return (Page<Object>) parameterObject;
            }else {
                return (Page<Object>) Reflections.getFieldValue(parameterObject,PAGE);
            }
        }catch (Exception e){
            return null;
        }
    }

    protected void initPropertie(Properties p){
        Dialect dialect = null;
        String dbType = Global.getConfig("jdbc.type");
        if ("mysql".equals(dbType)){
            dialect = new MySQLDialect();
        }
        if (dialect == null){
            throw new RuntimeException("Mybatis dialect error.");
        }
        DIALECT = dialect;
    }

}
