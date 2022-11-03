package com.example.hello.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base64Encoder")
public class Base64Enconder implements IEncoder{

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
