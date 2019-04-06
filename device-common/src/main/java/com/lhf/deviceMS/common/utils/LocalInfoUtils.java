package com.lhf.deviceMS.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取本地信息工具类
 */
public class LocalInfoUtils {

    /**
     * 获取本机ip地址
     * @return
     */
    public static String ipv4() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String ip=addr.getHostAddress().toString();
        return ip;
    }

    /**
     * 获取主机名
     * @return
     */
    public static String hostName() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String hostName=addr.getHostName().toString();
        return hostName;
    }
}
