package com.test.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class PrototypeController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(String name) {
        System.out.println("i'm controller");
        return name;
    }
}
