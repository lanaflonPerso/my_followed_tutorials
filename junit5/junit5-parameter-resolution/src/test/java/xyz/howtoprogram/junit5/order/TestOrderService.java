package xyz.howtoprogram.junit5.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
@ExtendWith(ReportAnnotationParameterResolver.class)
@ExtendWith(AuditServiceParameterResolver.class)
//@ExtendWith(EnvironmentNameParameterResolver.class)
class TestOrderService {

    @DisplayName("Test placeOrder method")
    @Test
    void placeOrderOK(TestInfo testInfo, TestReporter testReporter) {

        assertEquals("Test placeOrder method", testInfo.getDisplayName());
        testReporter.publishEntry("key", "value");

        assertEquals(1, 1);
    }

    @Test
    void placeOrderNoItem(AuditService auditService) {
        auditService.audit();
        assertEquals(1, 1);
    }

    @Test
    void placeOrderNG(@Report ReportService reportService) {
        reportService.report();
        assertEquals(1, 1);
    }

//	@Test
//	public void placeOrderNotLogin(EnvironmentInfo env) {
//		assertEquals("Windows 10", env.getOS());
//		assertEquals(1, 1);
//	}

}
