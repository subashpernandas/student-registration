package com.tech.subash.service;

import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.repository.UrbanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriterService {

    private final UrbanRepository urbanRepository;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void updateUrban(Long id, int newAge) {
        UrbanEntity urban = urbanRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        urban.setAge(newAge);
        urbanRepository.save(urban);

        try {
            Thread.sleep(5000); // 5 sec pause
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
