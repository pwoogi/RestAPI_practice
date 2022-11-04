package com.example.hello.controller;

import com.example.hello.annotation.Timer;
import com.example.hello.dto.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("get method");
        System.out.println("get id : " + id);
        System.out.println("get name : " + name);
        return id + " " + name;

    }

    @PostMapping("/posting")
    public Student post(@RequestBody Student student) {
        System.out.println("post method : " + student);
        return student;
    }

    @Timer
    @DeleteMapping("/deleting")
    public void delete() throws InterruptedException {

        //db logic

        Thread.sleep(1000*2);

    }
}
