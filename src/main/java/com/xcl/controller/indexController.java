package com.xcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
//@RequestMapping
public class indexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
