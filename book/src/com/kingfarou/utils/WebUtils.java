package com.kingfarou.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

    /**
     * http请求里的参数转bean
     *
     * @return 转变异常返回null，否则返回转变结果
     */
    public static <T> T copyParamToBean(Map<String, String[]> map, T bean) {
        try {
            BeanUtils.populate(bean, map);
            return bean;
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串解析成整数
     *
     * @param intString    待解析的字符串
     * @param defaultValue 如果解析异常，需要返回的默认值
     * @return 解析成功返回解析结果，否则返回默认值
     */
    public static int parseInt(String intString, int defaultValue) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            System.out.println("parseInt()异常->" + e.getMessage());
            return defaultValue;
        }
    }
}
