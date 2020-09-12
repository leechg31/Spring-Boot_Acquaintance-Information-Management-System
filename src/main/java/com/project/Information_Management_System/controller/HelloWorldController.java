package com.project.Information_Management_System.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leechg31@gmail.com
 * @since 2020-08-27
 */

@RestController  //command + b 누르면 해당 어노테이션 볼수있음
public class HelloWorldController {

    @PostMapping(value = "/api/helloWorld")  //POSTMapping으로 해당 http://localhost:8080/api/helloWorld를 만들어줌
    public String helloWorld()
    {
        return "HelloWorld";
    }
}
