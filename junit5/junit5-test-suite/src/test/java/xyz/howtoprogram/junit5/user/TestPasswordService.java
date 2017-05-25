package xyz.howtoprogram.junit5.user;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
 class TestPasswordService {
    @Test
     void changePasswordShortPassword() {
        assertEquals(1, 1);
    }
}
