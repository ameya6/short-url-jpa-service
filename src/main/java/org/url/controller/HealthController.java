package org.url.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jpa/url/health")
public class HealthController {

    @GetMapping
    public String health() {
        return "Healthy";
    }
}
