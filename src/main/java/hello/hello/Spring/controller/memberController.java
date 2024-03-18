package hello.hello.Spring.controller;

import hello.hello.Spring.service.service;
import org.springframework.stereotype.Controller;

@Controller
public class memberController {
    service service;

    public memberController(hello.hello.Spring.service.service service) {
        this.service = service;
    }
}
