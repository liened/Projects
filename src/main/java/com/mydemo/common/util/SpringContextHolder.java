package com.mydemo.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.net.URL;

@Slf4j
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware,DisposableBean{

    private static ApplicationContext applicationContext =  null;

    public static ApplicationContext getApplicationContext(){
        assertContextInjected();
        return applicationContext;
    }

    public static <T> T getBean(String name){
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> type){
        assertContextInjected();
        return applicationContext.getBean(type);
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public void destroy() throws Exception {
        SpringContextHolder.clearHolder();
    }

    public static void clearHolder(){
        if (log.isDebugEnabled()){
            log.debug("清除SpringContextHolder中的ApplicationContext:{}",applicationContext);
            applicationContext =  null;
        }
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected(){
        Validate.validState(applicationContext != null,"applicationContext属性未注入，请在applicationContext.xml中定义SpringContextHolder.");
    }
}
