package com.tech.subash.repository;

import com.tech.subash.dto.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRedisRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByAge(int age);
    List<User> findByNameAndAge(String name,int age);


}
