package com.baeldung;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Test case")
public class TaggedTest {

    @Test
    @Tag("Method")
    void testMethod() {
        assertEquals(2 + 2, 4);
    }
}
