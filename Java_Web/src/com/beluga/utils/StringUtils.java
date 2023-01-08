package com.beluga.utils;

/**
 * @author Beluga
 * @createTime 2022/12/31 -- 22:41
 */
public class StringUtils {
    /**
     * 判断字符串是否为null且是否为空串
     * @param str 字符串
     * @return true:str不为null且不为空串 false:str为null或为空串
     */
    public static boolean isNotEmpity(String str){
        return str != null && !"".equals(str);
    }
}
