package com.exm.demo.common.entity;

import com.exm.demo.common.persistence.Page;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable{

    protected Page<T> page;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
