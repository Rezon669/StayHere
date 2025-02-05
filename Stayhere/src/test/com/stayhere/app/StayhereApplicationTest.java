package com.stayhere.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

public final class StayhereApplicationTest {
    ///region Test suites for executable com.stayhere.app.StayhereApplication.main

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method main([Ljava.lang.String;)

    /**
     * @utbot.classUnderTest {@link StayhereApplication}
     * @utbot.methodUnderTest {@link StayhereApplication#main(String[])}
     * @utbot.invokes {@link SpringApplication#run(Class, String[])}
     */
    @Test
    @DisplayName("main: -> SpringApplicationRun")
    public void testMain_SpringApplicationRun() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(SpringApplication.class);
            (mockedStatic.when(() -> SpringApplication.run(any(Class.class), any(String[].class)))).thenReturn(((ConfigurableApplicationContext) null));

            StayhereApplication.main(null);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: SECURITY for method main([Ljava.lang.String;)

    /**
     * @utbot.classUnderTest {@link StayhereApplication}
     * @utbot.methodUnderTest {@link StayhereApplication#main(String[])}
     */
    @Test
    @DisplayName("main: arg_0 = String[3]")
    @Disabled(value = "Disabled due to sandbox")
    public void testMainWithNonEmptyObjectArray() {
        String[] args = {"XZ", "\n\t\r", "-3"};
        
        /* This test fails because method [com.stayhere.app.StayhereApplication.main] produces [java.security.AccessControlException: access denied ("java.util.PropertyPermission" "java.awt.headless" "read")]
            java.base/java.security.AccessControlContext.checkPermission(AccessControlContext.java:485)
            java.base/java.security.AccessController.checkPermission(AccessController.java:1068)
            java.base/java.lang.SecurityManager.checkPermission(SecurityManager.java:416)
            java.base/java.lang.SecurityManager.checkPropertyAccess(SecurityManager.java:1160)
            java.base/java.lang.System.getProperty(System.java:964)
            org.springframework.boot.SpringApplication.configureHeadlessProperty(SpringApplication.java:444)
            org.springframework.boot.SpringApplication.run(SpringApplication.java:308)
            org.springframework.boot.SpringApplication.run(SpringApplication.java:1361)
            org.springframework.boot.SpringApplication.run(SpringApplication.java:1350)
            com.stayhere.app.StayhereApplication.main(StayhereApplication.java:12) */
    }
    ///endregion

    ///endregion
}
