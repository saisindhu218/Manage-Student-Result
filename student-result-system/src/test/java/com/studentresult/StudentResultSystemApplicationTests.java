package com.studentresult; // This MUST match the package of StudentResultSystemApplication.java

    import org.junit.jupiter.api.Test; // Correct for JUnit 5
    import org.springframework.boot.test.context.SpringBootTest;

    @SpringBootTest(classes = StudentResultSystemApplication.class)
    class StudentResultSystemApplicationTests {

        @Test
        void contextLoads() {
            // This test simply checks if the Spring application context loads successfully.
        }

    }