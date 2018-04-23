package com.mydemo.common.config;


import com.google.common.collect.Maps;
import com.mydemo.common.util.PropertiesLoader;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 全局配置类
 */
public class Global {
    /**
     * 当前对象实例
     */
    private static Global global = new Global();
    /**
     * 保存全局属性值
     */
    private static Map<String,String> map = Maps.newHashMap();
    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("application.properties");

    public static Global getInstance(){
        return global;
    }

    public static String getConfig(String key){
        String value = map.get(key);
        if (value == null){
            value = loader.getProperty(key);
            map.put(key,value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }


}
