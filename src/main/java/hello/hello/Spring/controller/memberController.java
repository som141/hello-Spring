package hello.hello.Spring.controller;

import hello.hello.Spring.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class memberController {
    service service;
    @Autowired
    public memberController(hello.hello.Spring.service.service service) {
        this.service = service;
    }
}
