package com.tech.subash.controller.redis;

import com.tech.subash.dto.User;
import com.tech.subash.repository.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisDataController {

    @Autowired
    private UserRedisRepository userRedisRepo;

    @PostMapping("/post")
    public User store(@RequestBody User user){
        return userRedisRepo.save(user);
    }

    @GetMapping("/{redisHash}")
    public User getUserById(@PathVariable("redisHash") Long id) {
        return userRedisRepo.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<User> getNamae(@PathVariable("name") String name) {
        return userRedisRepo.findByName(name);
    }

    @GetMapping("/age/{age}")
    public List<User> getAge(@PathVariable("age") int age) {
        return userRedisRepo.findByAge(age);
    }


    @GetMapping("/{name}/{age}")
    public List<User> getAge(@PathVariable("name") String name,@PathVariable("age") int age) {
        return userRedisRepo.findByNameAndAge(name,age);
    }
}
