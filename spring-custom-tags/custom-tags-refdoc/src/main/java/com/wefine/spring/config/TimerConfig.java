package com.wefine.spring.config;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TimerConfig {
    private SimpleDateFormat dateFormat;

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}
