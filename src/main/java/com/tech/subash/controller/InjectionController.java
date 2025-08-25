package com.tech.subash.controller;

import com.tech.subash.service.impl.InjectionService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class InjectionController {

    private final InjectionService injectionService;

    //@Autowired(required = false)
    public InjectionController( @Nullable InjectionService injectionService) {
        this.injectionService = injectionService;
    }

   /* public void  setInjectionService(InjectionService injectionService){
        this.injectionService = injectionService;
    }*/
}
