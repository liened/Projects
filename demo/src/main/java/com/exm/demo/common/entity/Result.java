package com.exm.demo.common.entity;

import com.exm.demo.common.persistence.Page;

public class Result<T> {

    private String status = "200";
    private String message;
    private Page<T> pager;
    private Object object;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Page<T> getPager() {
        return pager;
    }

    public void setPager(Page<T> pager) {
        this.pager = pager;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
