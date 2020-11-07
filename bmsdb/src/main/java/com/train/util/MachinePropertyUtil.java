package com.train.util;

import java.util.Properties;

/**
 * 虚拟机信息
 *
 * @author 徐春福
 */
public final class MachinePropertyUtil {
    private static Properties env = System.getProperties();

    /**
     * Java的运行环境版本
     *
     * @return
     */
    public static String getJVMVersion() {
        return env.getProperty("java.version");
    }

    /**
     * 操作系统的名称
     *
     * @return
     */
    public static String getOSName() {
        return env.getProperty("os.name");
    }

    /**
     * 操作系统的构架
     *
     * @return
     */
    public static String getOSArch() {
        return env.getProperty("os.arch");
    }

    /**
     * 操作系统的版本
     *
     * @return
     */
    public static String getOSVersion() {
        return env.getProperty("os.version");
    }

    /**
     * CPU个数
     *
     * @return
     */
    public static String getProcessors() {
        return Runtime.getRuntime().availableProcessors() + "";
    }

}
