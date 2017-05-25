package com.howtoprogram.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@RunWith(JUnitPlatform.class)
class StringUtilsTestUnit5 {

    @Test
    void testConvertToDoubleOK() {
        // Test case with the age is a numeric string
        String age = "1990";
        Double expAge = Double.valueOf(age);
        Double actual = StringUtils.convertToDouble(age);

        assertAll("Do many assertions.", () -> {
            assertNotNull(actual);
            assertEquals(expAge, actual);
        });

        // Or Java 8 Lambdas style

        assertAll("Do many assertions.Java 8 Lambdas style", () -> {
            assertNotNull(actual, () -> "The actual is NULL");
            assertEquals(expAge, actual,
                    () -> "The expected is: " + expAge + " while the actual is:" + actual);
        });
    }

    @Test
    void testConvertToDoubleWithNullArgument() {
        // Test case with the age is null
        String age = null;
        Double actual = StringUtils.convertToDouble(age);
        assertNull(actual, "The actual is not null");
        // Java 8 Style
        assertNull(actual, () -> "The actual is not null");
    }


    @Test
    void testConvertToDoubleThrowException() {
        // Test with the age is a non numeric string
        String age = "N/A";
        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });

        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });
    }

    @Test
    void testIsNullOrBlankOK() {
        // Test the case that the input is NULL
        String input = null;

        assertTrue(StringUtils.isNullOrBlank(input));
        // Java 8 Lambdas Style
        assertTrue(StringUtils.isNullOrBlank(input), () -> "The string is not null or blank");

        // Test case with the input is empty
        input = " ";
        assertTrue(StringUtils.isNullOrBlank(input));

        // Test case with the input is not empty
        input = "abc";

        assertFalse(StringUtils.isNullOrBlank(input));

    }

    @Test
    void testGetDefaultIfNull() {
        // Test case with input string is null
        String st = null;
        String defaultSt = "abc";

        String actual = StringUtils.getDefaultIfNull(st, defaultSt);
        assertSame(defaultSt, actual);
        // Java 8 Lambdas Style
        assertSame(defaultSt, actual, () -> "Expected ouput is not same with actual");

        // Test case with input string is not null
        st = "def";

        actual = StringUtils.getDefaultIfNull(st, defaultSt);
        assertNotSame(defaultSt, actual);
        // Java 8 Lambdas Style
        assertNotSame(defaultSt, actual, () -> "Expected ouput is same with actual");

        // Test case with input string is empty
        st = "";
        actual = StringUtils.getDefaultIfNull(st, defaultSt);
        if (actual.equals(defaultSt)) {
            fail("The actual should be empty");

            // Java 8 Lambdas Style
            fail(() -> "The actual should be empty");
        }
    }

    @Disabled
    @Test
    void testConcatWithAllNullInput() {
        String actual = StringUtils.concat();
        assertNull(actual);
    }
}
