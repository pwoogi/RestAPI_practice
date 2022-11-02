package com.example.hello;

import com.example.hello.objectmappertest.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("--------");

        //Text JSON -> Object
        //Object -> Text JSON

        var objectMapper = new ObjectMapper();

        //object -> text (get method 활용)
        var user = new Member("User", 10, "010-2424-2424");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object (default constructor 필요)
        var objectMember = objectMapper.readValue(text, Member.class);
        System.out.println(objectMember);


    }

}
