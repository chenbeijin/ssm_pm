package com.sh303.ssm_pm.utils;

import java.util.UUID;

/**
 * 产生UUID随机字符串工具类
 */
public final class UuidUtils {

    private UuidUtils() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println(UuidUtils.getUuid().length());
        System.out.println(UuidUtils.getUuid());
        System.out.println(UuidUtils.getUuid());
        System.out.println(UuidUtils.getUuid());
    }
}
