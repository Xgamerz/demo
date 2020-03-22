package com.example.demo.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableWebSecurity
@RequestMapping(path = "/api/security/")
public class SecurityController {

    @GetMapping("getMsg")
    @PreAuthorize("hasRole('admin')")
    public String getMessage(@RequestParam(value = "id", defaultValue = "") String id) {
        System.out.println("controller");
        return "Get Security Message";
    }

    @GetMapping("getUserMsg")
    @PreAuthorize("hasRole('user')")
    public String getUserMessage(@RequestParam(value = "id", defaultValue = "") String id) {
        System.out.println("controller");
        return "Get User Security Message";
    }
}
