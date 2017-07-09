package com.wefine.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath*:spring-datasource.xml")
public class DataConfig {


}
