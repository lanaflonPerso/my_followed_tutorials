package com.howtoprogram.junit5;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class StringUtilsTestUnit5Exception {

    @Test
    void convertToIntNullParameterAssertThrows() {
        String st = null;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.convertToInt(st);
        });
    }

    @Test
    void convertToIntNullParameterExpectThrows() {
        String st = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.convertToInt(st);
        });
        assertEquals("String must be not null or empty", exception.getMessage());
    }

    @Test
    void convertToIntNullParameterTryCatchIdiom() {
        String st = null;
        try {
            StringUtils.convertToInt(st);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("String must be not null or empty", e.getMessage());
        }
    }
}
