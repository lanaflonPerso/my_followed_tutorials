package com.howtoprogram.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
 class TranslationEngineTest {

    private TranslatorEngine translatorEngine;

    @BeforeEach
     void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    @Test
     void testTranlsateHello() {
        assertEquals("Bonjour", translatorEngine.tranlate("Hello"));
    }

    @Test
     void testTranlsateYes() {
        assertEquals("Oui", translatorEngine.tranlate("Yes"));
    }

    @Test
     void testTranlsateNo() {
        assertEquals("Non", translatorEngine.tranlate("No"));
    }

}
