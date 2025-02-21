package com.example;

import com.example.service.BasicService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MockTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    BasicService service;

    @Test
    public void test() {
        given(service.test(0))
                .willReturn("Spring Boot Service Test");

        String result = restTemplate.getForObject("/test?flag=0", String.class);
        assertThat(result)
                .isEqualTo("Spring Boot Service Test");
    }

    @Test
    public void mockTest() {
        given(service.test(0))
                .willReturn("Spring Boot Service Test");

        assertThat(service.test(0))
                .isEqualTo("Spring Boot Service Test");
    }

    @Test
    public void test2() {
        given(service.test2(1))
                .willReturn("test complete");
        given(service.test2(0))
                .willReturn("test incomplete");

        String test_complete = restTemplate.getForObject("/test2?flag=1", String.class);
        String test_incomplete = restTemplate.getForObject("/test2?flag=0", String.class);

        assertThat(test_complete)
                .isEqualTo("test complete");
        assertThat(test_incomplete)
                .isEqualTo("test incomplete");
    }
}
