package xyz.howtoprogram.junit5.order;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class TestOrderService {

    @Test
     void placeOrderNoItem() {
        assertEquals(1, 1);
    }
}
