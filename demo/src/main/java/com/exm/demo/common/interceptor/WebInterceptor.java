package com.exm.demo.common.interceptor;

import com.exm.demo.common.config.WebInterceptorConfig;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebInterceptor implements HandlerInterceptor{

    private String sysUrl;

    public WebInterceptor(String sysUrl){
        this.sysUrl = sysUrl;
    }

    //处理前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("******************** preHandle "+request.getRequestURI()+" ********************");
        request.setAttribute("startTime",System.currentTimeMillis());
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Origin", WebInterceptorConfig.getOrigin(request,sysUrl));
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        return true;
    }

    //请求处理完成
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("******************** postHandle ********************");
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("******************** 请求"+request.getRequestURI()+"处理时间:"+(endTime-startTime)+" ********************");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
