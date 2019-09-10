package com.service.auth.serviceauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunhao
 * @Date 2019/9/10 16:32
 * @Version 1.0.0
 */
@RestController
public class TestController {

    @GetMapping(value = "/test/t")
    public String getUser() {

        return "principal";
    }
}
