package com.mydemo.common.util;

import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author ThinkGem
 * @version 2013-01-15
 */
//TODO
public class IdGen{

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
