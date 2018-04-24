package com.mydemo.modules.sys.utils;

import com.mydemo.common.util.CacheUtils;
import com.mydemo.common.util.SpringContextHolder;
import com.mydemo.modules.sys.dao.UserDao;
import com.mydemo.modules.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import com.mydemo.modules.sys.security.SystemAuthorizingRealm.Principal;

public class UserUtils {

    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";

    /**
     * 根据ID获取用户
     * @param id
     * @return 取不到返回null
     */
    public static User get(String id){
        User user = (User)CacheUtils.get(USER_CACHE,USER_CACHE_ID_+id);
        if (user == null){
            user = userDao.get(id);
            if (user == null){
                return null;
            }
            CacheUtils.put(USER_CACHE,USER_CACHE_ID_+user.getId(),user);
            CacheUtils.put(USER_CACHE,USER_CACHE_LOGIN_NAME_+user.getLoginName(),user);
        }
        return user;
    }

    /**
     * 根据登录名获取用户
     * @param loginName
     * @return 取不到返回null
     */
    public static User getByLoginName(String loginName){
        User user = (User)CacheUtils.get(USER_CACHE,USER_CACHE_LOGIN_NAME_+loginName);
        if (user == null){
            user = userDao.getByLoginName(loginName);
            if (user == null){
                return null;
            }
            CacheUtils.put(USER_CACHE,USER_CACHE_ID_+user.getId(),user);
            CacheUtils.put(USER_CACHE,USER_CACHE_LOGIN_NAME_+user.getLoginName(),user);
        }
        return user;
    }

    /**
     * 清除当前用户缓存
     */
    public static void clearCache(){
        UserUtils.clearCache(getUser());
    }

    public static void clearCache(User user){
        CacheUtils.remove(USER_CACHE,USER_CACHE_ID_+user.getId());
        CacheUtils.remove(USER_CACHE,USER_CACHE_LOGIN_NAME_+user.getLoginName());
        //TODO oldLoginName ？？
    }
    /**
     * 获取当前用户
     * @return 取不到返回 new User()
     */
    public static User getUser(){
        Principal principal = getPrincipal();
        if (principal != null){
            User user = get(principal.getId());
            if (user != null){
                return user;
            }
            return new User();
        }
        //如果没有登录，则返回实例化空的User对象
        return new User();
    }

    public static Principal getPrincipal(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal) subject.getPrincipal();
            if (principal != null){
                return principal;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取授权主要对象
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Session getSession(){
         try{
             Subject subject = SecurityUtils.getSubject();
             Session session = subject.getSession(false);
             if (session == null){
                 session = subject.getSession();
             }
             if (session != null){
                 return session;
             }
         }catch (InvalidSessionException e){

         }
         return null;
    }
}
