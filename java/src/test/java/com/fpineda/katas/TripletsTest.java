package com.fpineda.katas;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripletsTest {

    @Test
    void shouldReturn_2() {
        var elements = Arrays.asList(new Long[] {1L, 2L, 2L, 4L});
        var ratio = 2;

        Assertions.assertEquals(2, Triplets.count(elements, ratio));
    }

    @Test
    void shouldReturn_6() {
        var elements = Arrays.asList(new Long[] {1L, 3L, 9L, 9L, 27L, 81L});
        var ratio = 3;

        Assertions.assertEquals(6, Triplets.count(elements, ratio));
    }

    @Test
    void complexTest_ShouldReturn_161700() {
        var array = new Long[100];
        Arrays.fill(array, 1L);
        var elements = Arrays.asList(array);
        var ratio = 1L;

        Assertions.assertEquals(161700, Triplets.count(elements, ratio));
    }

    @Test
    void complexTest_ShouldReturn_10() {
        var array = new Long[5];
        Arrays.fill(array, 1L);
        var elements = Arrays.asList(array);
        var ratio = 1L;

        Assertions.assertEquals(10, Triplets.count(elements, ratio));
    }

    //@Test
    void reallyBigTest_ShouldReturn_2325652489() {
        var array = new Long[]{1L, 31L};
        Arrays.fill(array, 1L);
        var elements = Arrays.asList(array);
        var ratio = 1L;

        Assertions.assertEquals(2325652489L, Triplets.count(elements, ratio));
    }



}
