package com.lhf.deviceMS.common.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * 加密工具类
 */
public class EncryptionUtils {
    public static String md5(String content,String key) {
        return Hashing.md5().newHasher().putString(content + key, Charsets.UTF_8).hash().toString().toUpperCase();
    }


    public static String md5(String content) {
        byte[] md5b = Hashing.md5().newHasher().putString(content, Charsets.UTF_8).hash().asBytes();

        return bytesToHex(md5b);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    //rsa
}
