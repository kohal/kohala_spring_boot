package com.reflex.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/6/29
 */
@RestController
public class Reflex {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
