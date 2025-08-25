package com.tech.subash.service;

import com.tech.subash.repository.LogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MandatoryPropagationTest {

    @Autowired
    OuterService outerService;

    @Autowired
    private LogRepository repo;

    @Test
     void testWithTransaction() {
        outerService.doWorkWithTransaction();
    }

    @Test
     void testWithoutTransaction() {
        outerService.doWorkWithoutTransaction();
    }

    @Test
    public void testNotSupported() {
        try {
            outerService.doWorkWithTransactionForUnSupported();
        } catch (Exception ignored) {}

        System.out.println("Entries in DB: " + repo.findAll());
    }
}
