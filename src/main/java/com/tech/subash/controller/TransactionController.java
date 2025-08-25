package com.tech.subash.controller;

import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TransactionalService transactionalService;

    @PostMapping("/post")
    public UrbanEntity urban(@RequestBody UrbanEntity urban){
        return transactionalService.storeUrbanDetails(urban);
    }

    @PostMapping("/post2/{id}/{age}")
    public UrbanEntity urbanStore(@PathVariable("id") long id, @PathVariable("age") int age){
        return transactionalService.storeUrbanDetailsDetails(id, age);
    }

    @GetMapping("/{id}")
    public UrbanEntity getUrbanDetails(@PathVariable("id") long id) {
        return  transactionalService.getUrbanDetails(id);
    }

}
