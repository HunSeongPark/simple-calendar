package com.hunseong.calendar.core.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Hunseong on 2022/06/09
 */
class BCryptEncryptorTest {

    @Test
    void test() {
        final String origin = "password";
        final Encryptor encryptor = new BCryptEncryptor();
        final String hash = encryptor.encrypt(origin);

        assertThat(encryptor.isMatch(origin, hash)).isTrue();

        final String origin2 = "passwordd";
        assertThat(encryptor.isMatch(origin2, hash)).isFalse();
    }
}