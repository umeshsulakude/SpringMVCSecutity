package com.springmvc.secapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecController {

    @GetMapping("/hi")
    public String Hi() {
        return "HI !!!";
    }

    @GetMapping("/bye")
    public String Bye() {
        return "BYE !!!";
    }
}
