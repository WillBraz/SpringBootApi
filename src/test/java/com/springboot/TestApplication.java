package com.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestApplication {
    
    @Test
    public void testHelloWorld(){
        assertEquals(1,1);
    }
}