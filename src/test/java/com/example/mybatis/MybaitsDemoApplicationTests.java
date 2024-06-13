package com.example.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String a = "BearereyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImNyZWF0ZWQiOjE1OTM5MTk4MjkyNjgsImV4cCI6MTU5NDUyNDYyOX0.22DJvzieADWG1GQlm5D9iogslj2a24LXqrEKKI6KG2KBhcwDP-KpeRHkgGSK0WV3rgpFBXwevCzbLmuLkr0MNw";
        boolean b = a.startsWith("Bearer");
        System.out.println(b);
    }

}
