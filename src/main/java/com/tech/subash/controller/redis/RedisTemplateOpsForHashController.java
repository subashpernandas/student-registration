package com.tech.subash.controller.redis;


import com.tech.subash.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/redis/hash")
public class RedisTemplateOpsForHashController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public void saveUser(@RequestBody UserDto userDto) {
        String redisKey = "user:1001";
        redisTemplate.opsForHash().put(redisKey, "id", userDto.getId());
        redisTemplate.opsForHash().put(redisKey, "name", userDto.getName());
        redisTemplate.opsForHash().put(redisKey, "email", userDto.getEmail());
    }

    @GetMapping("/all")
    public String getUserName() {
        String redisKey = "user:1001";
        return (String) redisTemplate.opsForHash().get(redisKey, "name");
    }

    @GetMapping("/all-fields")
    public Map<Object, Object> getUser() {
        String redisKey = "user:1001";
        return redisTemplate.opsForHash().entries(redisKey);
    }

    @DeleteMapping
    public void deleteUserEmail() {
        String redisKey = "user:1001";
        redisTemplate.opsForHash().delete(redisKey, "email");
    }

}
