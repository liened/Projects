package com.mydemo.common.persistence;

import com.mydemo.common.util.IdGen;
import com.mydemo.modules.sys.entity.User;
import com.mydemo.modules.sys.utils.UserUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 数据Entity类
 */
public class DataEntity<T> extends BaseEntity<T> {

    protected String remark;    // 备注
    protected User createBy;     // 创建者
    protected Date createTime;  // 创建日期
    protected User updateBy;     // 更新者
    protected Date updateTime;  // 更新日期
    protected int defFlag = 0;   // 删除标记（0：正常；1：删除；2：审核）

    public DataEntity(){
        super();
    }

    public DataEntity(String id){
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        //不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord){
            setId(IdGen.uuid());
        }
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())){
            this.createBy = user;
            this.updateBy = user;
        }
        this.updateTime = new Date();
        this.createTime = this.updateTime;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user;
        }
        this.updateTime = new Date();
    }
}
