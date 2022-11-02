package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // service단에서 해야하지만 우선 복습겸 시행
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();
        user.setName("chris");
        user.setAddress("이촌동");
        return user;

    }
}
