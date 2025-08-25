package com.tech.subash.service;

import com.tech.subash.entity.LogEntity;
import com.tech.subash.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceB {

    private final LogRepository repo;

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodRequired() {
        repo.save(new LogEntity("Required executed"));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodRequiresNew() {
        repo.save(new LogEntity("RequiredNew executed"));
    }

    @Transactional(propagation = Propagation.NESTED)
    public void methodNested() {
        repo.save(new LogEntity("Nested executed"));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodRequiresNewAndFails() {
        repo.save(new LogEntity("methodRequiresNewAndFails executed"));
        throw new RuntimeException("Forcing rollback in REQUIRES_NEW");
    }
}
