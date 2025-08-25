package com.tech.subash.service;

import com.tech.subash.entity.LogEntity;
import com.tech.subash.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class LogService {

    @Autowired
    private LogRepository repo;

    @Transactional(propagation = Propagation.MANDATORY)
    public void logMessage(String msg) {
        repo.save(new LogEntity(msg));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void logOutsideTransaction(String msg) {
        System.out.println("Transaction active 11 ? " +
                TransactionSynchronizationManager.isActualTransactionActive()); // false
        repo.save(new LogEntity(msg));
    }
}
