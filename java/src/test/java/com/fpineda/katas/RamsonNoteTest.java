package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RamsonNoteTest {

    @Test
    void shouldReturn_True(){
        var magazine = new String[]{"give", "me", "one",  "grand", "today", "night"};
        var note = new String[]{"give", "one",  "grand", "today"};

        Assertions.assertTrue(RamsonNote.canWrite(magazine, note));
    }
    
}
