package com.mydemo.common.persistence.interceptor;

import com.mydemo.common.persistence.Page;
import com.mydemo.common.persistence.dialect.Dialect;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;

import java.io.Serializable;

/**
 * Mybatis分页拦截器基类
 */
@Slf4j
public abstract class BaseInterceptor implements Interceptor,Serializable{

    protected static final String PAGE = "page";

    protected static final String DELEGATE = "delegate";

    protected static final String MAPPED_STATEMENT = "mappedStatement";

    protected Dialect DIALECT;

    protected static Page<Object> convertParameter(Object paramterObject, Page<Object> page){
        try {
            if (paramterObject instanceof Page){
                return (Page<Object>) paramterObject;
            }else {
                //return Refl
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

}
