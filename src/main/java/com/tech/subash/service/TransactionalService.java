package com.tech.subash.service;

import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.repository.UrbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class TransactionalService {

    @Autowired
    private UrbanRepository urbanRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;


    //@Transactional
    public UrbanEntity storeUrbanDetails(UrbanEntity urban) {
        return transactionTemplate.execute(status -> {
            try {
                urbanRepository.save(urban);
                if (urban.getName().equalsIgnoreCase("theni")) {
                    throw new RuntimeException("error occured");
                }
                return urban;
            } catch (Exception e) {
                status.setRollbackOnly();
                throw e;
            }
        });
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED )
    public UrbanEntity storeUrbanDetailsDetails(long id, int age) {
        UrbanEntity urban1 = urbanRepository.findById(id).get();
        urban1.setAge(age);
        urbanRepository.save(urban1);
        try {
            TimeUnit.SECONDS.sleep(25); // 25 sec pause
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return urban1;
    }


    @Transactional(isolation = Isolation.READ_UNCOMMITTED )
    public UrbanEntity getUrbanDetails(long id) {
        UrbanEntity urban1 = urbanRepository.findById(id).get();
        return  urban1;
    }
}
