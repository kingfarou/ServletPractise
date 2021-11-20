package com.kingfarou.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(Map<String, String[]> map, T bean){
        try {
            BeanUtils.populate(bean, map);
            return bean;
        } catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
