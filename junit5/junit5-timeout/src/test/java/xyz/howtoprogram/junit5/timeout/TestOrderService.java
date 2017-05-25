package xyz.howtoprogram.junit5.timeout;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@RunWith(JUnitPlatform.class)
class TestOrderService {
    @Test
    void doPaymentNotExceed15Seconds() {
        OrderService orderService = new OrderService();
        assertTimeout(ofSeconds(15), () -> {
            // This method runs in 10 seconds
            orderService.doPayment();
        });
    }

    @Test
    void doPaymentExceed5Seconds() {
        OrderService orderService = new OrderService();
        assertTimeout(ofSeconds(5), () -> {
            // This method runs in 10 seconds
            orderService.doPayment();
        }, "The doPayment method take more than 5 seconds");
    }

    @Test
    void printShippingLabelExceeded15SecondsWithPreemptiveTermination() {
        OrderService orderService = new OrderService();
        assertTimeoutPreemptively(ofSeconds(15), () -> {
            // This method takes 20 seconds to run
            orderService.printShippingLabel();
        }, () -> "The printShippingLabel method took more than 15 seconds and was aborted.");
    }
}
