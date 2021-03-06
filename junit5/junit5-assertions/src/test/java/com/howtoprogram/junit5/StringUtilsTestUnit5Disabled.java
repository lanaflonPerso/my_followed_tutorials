package com.howtoprogram.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(JUnitPlatform.class)
class StringUtilsTestUnit5Disabled {

    @Test
    void testConcatWithRegularInput() {
        String st1 = "Hello";
        String st2 = "World";
        String st3 = "!";
        String expect = st1 + st2 + st3;
        String actual = StringUtils.concat(st1, st2, st3);
        assertEquals(expect, actual);
    }

    @Disabled
    @Test
    void testConcatWithNullInput() {
        String st1 = "Hello";
        String st2 = "World";
        String st3 = null;
        String expect = st1 + st2;
        String actual = StringUtils.concat(st1, st2, st3);
        assertEquals(expect, actual);
    }

    @Test
    void testConcatWithAllNullInput() {
        String actual = StringUtils.concat();
        assertNull(actual);
    }
}
