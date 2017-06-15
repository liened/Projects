package com.exm.demo.common.dao;

import java.util.List;

public interface BaseDao<T> {

    T get(String id);

    T get(T t);

    List<T> findList(T t);

    int insert(T t);

    int update(T t);

    int delete(T t);

    int delete(String id);
}
