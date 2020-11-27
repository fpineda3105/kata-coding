package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepeatedStringTest {

    @Test
    void shouldReturn_100000() {
        var str = "a";

        Assertions.assertEquals(10000, RepeatedString.count(str, 10000));
    }
    

    @Test
    void shouldReturn_4() {
        var str = "abcac";

        Assertions.assertEquals(4, RepeatedString.count(str, 10));
    }

    @Test
    void shouldReturn_3() {
        var str = "abcac";

        Assertions.assertEquals(3, RepeatedString.count(str, 8));
    }
}
