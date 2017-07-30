package com.exm.demo.common.config;

import com.exm.demo.common.interceptor.WebInterceptor;
import com.exm.demo.common.utils.PropertieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
public class WebInterceptorConfig extends WebMvcConfigurerAdapter{

    @Autowired
    PropertieUtils propertieUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String requestUrl = propertieUtils.getRequestUrl();
        System.out.println("====="+requestUrl+"======");
        registry.addInterceptor(new WebInterceptor(propertieUtils.getRequestUrl())).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


    public static String getOrigin(HttpServletRequest request,String sysUrl){
        Enumeration en = request.getHeaders("Origin");
        String[] sysUrls = sysUrl.split(",");
        while(en.hasMoreElements()){
            String requestUrl = (String)en.nextElement();
            for(String url:sysUrls){
                if(url.equals(requestUrl)){
                    return url;
                }
            }
        }
        return null;
    }
}
