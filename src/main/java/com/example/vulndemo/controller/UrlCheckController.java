package com.example.vulndemo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {

    @PostMapping("/api/url/check")
    public String check(@RequestBody String body) {
        System.out.println("[Controller] " + body);
        Object result = JSON.parse(body);
        return "ok: " + result;
    }
}
