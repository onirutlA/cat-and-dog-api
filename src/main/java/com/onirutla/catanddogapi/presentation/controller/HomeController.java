package com.onirutla.catanddogapi.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String baseurl() {
        return "Click this <a href =\"https://github.com/onirutlA/cat-and-dog-api/blob/main/README.md\">URL</a> for guide to use this REST API";
    }
}
