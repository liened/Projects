package com.mydemo.modules.sys.service;

import com.mydemo.common.service.BaseService;
import com.mydemo.modules.sys.dao.UserDao;
import com.mydemo.modules.sys.entity.User;
import com.mydemo.modules.sys.security.shiro.session.SessionDAO;
import com.mydemo.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 */
@Service
@Transactional(readOnly = true)
public class SystemService extends BaseService implements InitializingBean{

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Autowired
    private UserDao userDao;
    @Autowired
    private SessionDAO sessionDAO;

    /**
     * 获取用户
     * @param id
     * @return
     */
    public User getUser(String id){
        return UserUtils.getUser(id);
    }

    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    public User getUserByLoginName(String loginName){
        return UserUtils.getByLoginName(loginName);
    }

    public SessionDAO getSessionDAO(){
        return sessionDAO;
    }

    public void afterPropertiesSet() throws Exception {

    }


}
