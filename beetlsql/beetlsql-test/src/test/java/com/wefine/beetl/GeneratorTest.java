package com.wefine.beetl;


import com.wefine.app.conf.BeetlMgt;
import org.beetl.sql.core.SQLManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


class GeneratorTest {
    private SQLManager sqlManager = BeetlMgt.getManager();

    @Test
    void test() throws Exception {
        Assert.assertNotNull(sqlManager);

        sqlManager.genPojoCodeToConsole("user");
        sqlManager.genSQLTemplateToConsole("user");
    }
}
