package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String getHello(){
        return "hello spring boot";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    @GetMapping("/path-variable/{name}") //실제로 사용하는 이름과 다르게 받을 때는 @PathVariable name 속성을 이용
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry-> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() +"\n");

        });

        return sb.toString();
    }

    @GetMapping(path = "query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
