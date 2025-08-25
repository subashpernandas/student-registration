package com.tech.subash.controller;

import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.repository.UrbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/idem")
public class PostVsPutController {


    @Autowired
    private UrbanRepository urbanRepository;

    @PostMapping // NON IDEMPOTENT
    public String createOrder(@RequestBody UrbanEntity urban) {
        UrbanEntity urbanEntity = urbanRepository.save(urban);
        return "UrbanEntity Created with id: " + urbanEntity.getId();
    }

    @PutMapping("/{id}")  // IDEMPOTENT
    public String updateUrban(@PathVariable("id") long id, @RequestBody UrbanEntity urban) {
        Optional<UrbanEntity> existingUrbanOpt = urbanRepository.findById(id);
        if (existingUrbanOpt.isPresent()) {
            UrbanEntity existingUrban = existingUrbanOpt.get();
            // update fields (idempotent: same data = same state)
            existingUrban.setName(urban.getName());
            existingUrban.setAge(urban.getAge());
            urbanRepository.save(existingUrban);
            return "UrbanEntity updated with id: " + id;
        } else {
            // create new if not found (some APIs do UPSERT behavior for PUT)
            urban.setId(id);
            urbanRepository.save(urban);
            return "UrbanEntity created with id: " + id;
        }
    }

    @PatchMapping("/{id}")  // IDEMPOTENT
    public UrbanEntity batchUrban(@PathVariable("id") long id, @RequestBody Map<String, Object> updates) {
        UrbanEntity existingUrban = urbanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UrbanEntity not found with id: " + id));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingUrban.setName((String) value);
                    break;
                case "age":
                    existingUrban.setAge(((Number) value).intValue());
                    break;
            }
        });
        return urbanRepository.save(existingUrban);
    }


    @GetMapping("/{id}")
    public UrbanEntity getOrders(@PathVariable("id") long id) {
        return urbanRepository.findById(id).orElseThrow(() -> new RuntimeException("Details Not found"));
    }

}
