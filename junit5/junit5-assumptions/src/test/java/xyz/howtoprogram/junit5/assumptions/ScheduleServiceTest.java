package xyz.howtoprogram.junit5.assumptions;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@RunWith(JUnitPlatform.class)
class ScheduleServiceTest {

    @Test
    void doScheduleSingleTimeZone() {

        TimeZone tzone = TimeZone.getDefault();
        // Assume that the timezone is US/Mountain
        assumeTrue(tzone.getDisplayName().equals("US/Mountain"));

        // Test doSchedule method
        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.doSchedule());
    }

    @Test
    void doScheduleLocaleNonUS() {

        // Assume that the current locale is US
        Locale currentLocale = Locale.getDefault();
        assumeTrue(currentLocale.equals(Locale.US));

        // Test doSchedule method
        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.doSchedule());

    }

    @Test
    void backupCalendarWindows() {

        assumeTrue(System.getProperty("os.name").startsWith("Windows"));

        // Test doSchedule method
        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.backupCalendar());

    }
}
