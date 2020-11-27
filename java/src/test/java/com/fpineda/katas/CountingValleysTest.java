package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingValleysTest {

    @Test
    void shouldReturn_OneValley() {
        var path = "UDDDUDUU";
        int length = 8;

        Assertions.assertEquals(1, CountingValleys.count(path, length));
    }
    
}
