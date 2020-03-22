package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/nosecurity/")
public class NoSecurityController {

    @GetMapping("getMsg")
    public String getMessage(@RequestParam(value = "id", defaultValue = "") String id) {
        System.out.println("controller");
        return "Get No Security Message";
    }
}