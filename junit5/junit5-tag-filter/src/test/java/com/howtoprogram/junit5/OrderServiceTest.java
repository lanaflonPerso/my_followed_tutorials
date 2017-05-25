package com.howtoprogram.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("service")
class OrderServiceTest {

    @Test
    @Tag("slow")
    void placeOrderTest() {
    }

    @Test
    @Tag("fast")
    void checkout() {
    }

    @Test
    @Tag("slow")
    void doPayment() {
    }

    @Test
    @Tag("fast")
    void validateOrder() {
    }
}
