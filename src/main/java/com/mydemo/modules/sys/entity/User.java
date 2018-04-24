package com.mydemo.modules.sys.entity;

import com.mydemo.common.persistence.DataEntity;
import lombok.Data;

@Data
public class User extends DataEntity<User>{

    private String userName;
    private String loginName;
    private String password;
    private String email;
    private String mobile;
    private String createId;
    private String updateId;
    private String loginFlag;	// 是否允许登陆

}
