package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringComparatorTest {

    @Test
    void shouldReturn_True() {
        var firstString = "hello";
        var secondString = "world";

        Assertions.assertTrue(StringComparator.containsSubStr(firstString, secondString));
    }
    
}
