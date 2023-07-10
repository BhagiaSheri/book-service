package miu.books.bookservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Software Architecture Lab # 2 (part-1) By Bhagia Sheri";
    }
}