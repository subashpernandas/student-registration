package com.tech.subash.controller.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.subash.dto.Student;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redis-client")
@RequiredArgsConstructor
public class RedisClientDemoController {

    private  final RedisClient redisClient;
    private final ObjectMapper objectMapper;


    @PostMapping
    public Student storeStudentDetails(@RequestBody Student student) throws JsonProcessingException {
        StatefulRedisConnection<String, String> connect = redisClient.connect();
        RedisCommands<String, String> sync = connect.sync();
        String value = objectMapper.writeValueAsString(student);
        sync.set("student", value);
        String s = sync.get("student");
        return objectMapper.readValue(s, Student.class);
    }
}
