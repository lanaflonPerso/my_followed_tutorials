package com.wefine.app.conf;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class BeetlMgt {
    // 单例
    private BeetlMgt() {
    }

    public static SQLManager getManager() {
        return SingleTon.SQL_MANAGER;
    }

    private static class SingleTon {
        private final static SQLManager SQL_MANAGER = init();

        private static SQLManager init() {
            EncodedResource resource = new EncodedResource(new ClassPathResource("mysql-application.properties"), StandardCharsets.UTF_8);
            Properties config;
            try {
                config = PropertiesLoaderUtils.loadProperties(resource);
            } catch (IOException e) {
                return null;
            }

            String driver = config.getProperty("jdbc.driverClassName");
            String url = config.getProperty("jdbc.url");
            String userName = config.getProperty("jdbc.username");
            String password = config.getProperty("jdbc.password");

            ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
            DBStyle mysql = new MySqlStyle();

            SQLLoader loader = new ClasspathLoader("/sql");

            UnderlinedNameConversion nc = new UnderlinedNameConversion();

            return new SQLManager(mysql, loader, source, nc, new Interceptor[]{new DebugInterceptor()});
        }
    }
}
