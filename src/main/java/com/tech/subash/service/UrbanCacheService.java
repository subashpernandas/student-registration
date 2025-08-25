package com.tech.subash.service;


import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.dto.UrbanDto;
import com.tech.subash.repository.UrbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UrbanCacheService {

    @Autowired
    private UrbanRepository urbanRepository;


    @CachePut(value = "urban_cache",key = "#urban.id",unless = "#result == null")
    public UrbanEntity storeUrbanDetails(UrbanEntity urban){
        return urbanRepository.save(urban);
    }

    @Cacheable(key = "#id", value = "urban_cache")
    public UrbanEntity findById(long id){
        return urbanRepository.findById(id).get();
    }

    @CachePut(key = "#id", value = "urban_cache",unless = "#result == null"	)
    public UrbanEntity updateById(long id, UrbanDto urbanDto){
       UrbanEntity urban = urbanRepository.findById(id).get();
       urban.setAge(urbanDto.getAge());
       urban.setName(urbanDto.getName());
       urbanRepository.save(urban);
       return urban;
    }
}
