package com.mydemo.common.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

public class PropertiesLoader {

    private final Properties properties;
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    public PropertiesLoader(String... resource){
        properties = this.loadProperties(resource);
    }

    public Properties getProperties(){
        return properties;
    }

    public String getValue(String key){
        String systemProperty = System.getProperty(key);
        if (systemProperty != null){
            return systemProperty;
        }
        if (properties.contains(key)){
            return properties.getProperty(key);
        }
        return "";
    }

    public String getProperty(String key){
        String value = getValue(key);
        if (value == null){
            throw new NoSuchElementException();
        }
        return value;
    }

    private Properties loadProperties(String... resourcePaths){
        Properties props = new Properties();
        for (String location:resourcePaths){
            InputStream is = null;
            try {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return props;
    }
}
