package com.example.web;

import com.example.domain.TestMessage;
import com.example.service.BasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BasicController {

    private BasicService service;

    @GetMapping("/test")
    public String test(@RequestParam("flag") int flag) {
        return service.test(flag);
    }

    @GetMapping("/jsonTest")
    public TestMessage jsonTest() {
        return service.jsonTest();
    }
}
