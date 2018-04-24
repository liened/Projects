package com.mydemo.modules.sys.web;

import com.google.common.collect.Maps;
import com.mydemo.common.util.CacheUtils;
import com.mydemo.common.web.BaseController;
import com.mydemo.modules.sys.security.shiro.session.SessionDAO;
import com.sun.javaws.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * 登录Controller
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private SessionDAO sessionDAO;

    /**
     * 是否是验证码登录
     * @param username 用户名
     * @param isFail 计数加1
     * @param clean 计数清零
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isValidateCodeLogin(String username, boolean isFail, boolean clean){
        Map<String,Integer> loginFailMap = (Map<String,Integer>)CacheUtils.get("loginFailMap");
        if (loginFailMap == null){
            loginFailMap = Maps.newHashMap();
            CacheUtils.put("loginFailMap",loginFailMap);
        }
        Integer loginFailNum = loginFailMap.get(username);
        if (loginFailMap == null){
            loginFailNum = 0;
        }
        if (isFail){
            loginFailNum++;
            loginFailMap.put(username,loginFailNum);
        }
        if (clean){
            loginFailMap.remove(username);
        }
        return loginFailNum >= 3;
    }
}
