package xyz.howtoprogram.junit5.payment;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class TestPaymentService {
    @Test
     void doPaymentZeroAmount() {
        assertEquals(1, 1);
    }
}
