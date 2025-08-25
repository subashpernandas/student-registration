package com.tech.subash.service;

import com.tech.subash.entity.LogEntity;
import com.tech.subash.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class OuterService {

    @Autowired
    private LogService logService;

    @Autowired
    private LogRepository repo;

    @Transactional
    public void doWorkWithTransaction() {
        logService.logMessage("Inside existing transaction");
    }

    // This does NOT start a transaction, so MANDATORY will fail
    @Transactional
    public void doWorkWithoutTransaction() {
        logService.logMessage("No transaction here"); // throws IllegalTransactionStateException
    }


    @Transactional
    public void doWorkWithTransactionForUnSupported() {
        repo.save(new LogEntity("Before NOT_SUPPORTED"));
        logService.logOutsideTransaction("Logged outside transaction");
        System.out.println("Transaction active 22 ? " +
                TransactionSynchronizationManager.isActualTransactionActive()); // true
        throw new RuntimeException("Simulate failure");
    }
}
