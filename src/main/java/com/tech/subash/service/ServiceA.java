package com.tech.subash.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceA {

    private final ServiceB serviceB;


    @Transactional
    public void outerWithRequired() {
        serviceB.methodRequired(); // same transaction
        throw new RuntimeException("Outer fails");
    }

    @Transactional
    public void outerWithRequiresNew() {
        serviceB.methodRequiresNew(); // independent transaction
        throw new RuntimeException("Outer fails");
    }

    @Transactional
    public void outerWithNested() {
        serviceB.methodNested(); // savepoint inside same transaction
        throw new RuntimeException("Outer fails");
    }

    @Transactional
    public void outerWithRequiresNewFailInside() {
        try {
            serviceB.methodRequiresNewAndFails(); // fails, but independent
        } catch (Exception e) {
            System.out.println("Inner failure caught");
        }
        // Outer transaction still alive here
    }
}
