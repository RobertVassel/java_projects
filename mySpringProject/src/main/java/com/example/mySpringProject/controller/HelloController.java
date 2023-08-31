package com.example.mySpringProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/helloworld")
  public String helloWorld() {
    return "In 2 months ill be a backend software dev";
  }
}
