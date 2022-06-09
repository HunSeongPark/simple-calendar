package com.hunseong.calendar.core.util;

/**
 * Created by Hunseong on 2022/06/09
 */
public interface Encryptor {
    String encrypt(String origin);
    boolean isMatch(String origin, String hashed);
}
