package com.mydemo.base.persistence;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEnrity<T> implements Serializable {

    protected String id;

}
