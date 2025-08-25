package com.tech.subash.controller.redis;


import com.tech.subash.dto.CattleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/value")
public class RedisTemplateOpsForValueController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public void saveUser(@RequestBody CattleDto user) {
        String key = "user:" + user.getId();
        redisTemplate.opsForValue().set(key, user);
    }
    @GetMapping("/{id}")
    public CattleDto getUser(@PathVariable("id") Long id) {
        String key = "user:" + id;
        return (CattleDto) redisTemplate.opsForValue().get(key);
    }

    @PostMapping("/1002")
    public void saveValue() {
        redisTemplate.opsForValue().set("user:1002:name", "Alice");
        redisTemplate.opsForValue().set("user:1002:age", 30);
    }

    @GetMapping("/name")
    public String getUserName() {
        return (String) redisTemplate.opsForValue().get("user:1002:name");
    }

    @GetMapping("/age")
    public Integer getUserAge() {
        return (Integer) redisTemplate.opsForValue().get("user:1002:age");
    }

    @DeleteMapping("/delete")
    public void deleteUserAge() {
        redisTemplate.delete("user:1002:age");
    }


}
