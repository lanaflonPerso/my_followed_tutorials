package com.wefine.distributed.arith;


import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;

public class MillisecondTest {

    @Test
    public void testGetMills() {
        LocalDate localDate = LocalDate.of(2017, 2, 17);
        ZoneId zoneId = ZoneId.systemDefault();
        long ms = localDate.atStartOfDay(zoneId).toEpochSecond();

        System.out.println(ms);
    }
}
