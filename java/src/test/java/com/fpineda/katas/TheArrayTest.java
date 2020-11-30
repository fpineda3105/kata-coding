package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheArrayTest {

    @Test
    void shouldReturn_5Swaps() {
        var array = new int[]{7, 1, 3, 2, 4, 5, 6};

        Assertions.assertEquals(5, 
        TheArray.minimalSwapsToOrder(array));

    }

    @Test
    void shouldReturn_3Swaps() {
        var array = new int[]{2, 3, 4, 1, 5};

        Assertions.assertEquals(3, 
        TheArray.minimalSwapsToOrder(array));

    }
    
}
