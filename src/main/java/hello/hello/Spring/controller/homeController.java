package hello.hello.Spring.controller;

import hello.hello.Spring.domain.member;
import hello.hello.Spring.service.service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }



}
