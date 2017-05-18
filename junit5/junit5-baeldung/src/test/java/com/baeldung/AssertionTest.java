package com.baeldung;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionTest {

    private static Integer convertToInt(String str) {
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str);
    }

    @Test
    void testConvertToDoubleThrowException() {
        String age = "eighteen";

        assertThrows(NumberFormatException.class, () -> {
            int i = convertToInt(age);
            System.out.println(i);
        });

        assertThrows(NumberFormatException.class, () -> {
            int i = convertToInt(age);
            System.out.println(i);
        });
    }

}
