package com.baeldung;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

//@RunWith(JUnitPlatform.class)
public class JUnit5NewFeaturesTest {

    private static final Logger log = Logger.getLogger(JUnit5NewFeaturesTest.class.getName());

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @AfterAll
    static void done() {
        log.info("@AfterAll - executed after all test methods.");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        log.info("Success");

    }

    @Test
    @Disabled("Not implemented yet.")
    void testShowSomething() {
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each test method.");
    }

}
