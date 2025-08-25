package com.tech.subash.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReaderService {

    private final JdbcTemplate jdbcTemplate;

    public ReaderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void readUrban(Long id) {
        Integer age = jdbcTemplate.queryForObject(
                "SELECT age FROM urban WHERE id = ?",
                Integer.class, id
        );
        System.out.println("Read urban age: " + age);
    }
}
