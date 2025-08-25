package com.tech.subash.controller.redis;

import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.dto.UrbanDto;
import com.tech.subash.repository.UrbanRepository;
import com.tech.subash.service.UrbanCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/student")
public class RedisAbstractAnnotationController {

	@Autowired
	private UrbanRepository urbanRepository;

	@Autowired
	private UrbanCacheService urbanService;

	@PostMapping("/post")
	public UrbanEntity storeUrbanDetails(@RequestBody UrbanEntity urban){
		return urbanService.storeUrbanDetails(urban);
	}

	@GetMapping("/findById/{id}")
	public UrbanEntity findById(@PathVariable("id") long id){
		return  urbanService.findById(id);
	}

	@PostMapping("/update/{id}")
	public UrbanEntity updateUrbanValue(@PathVariable("id") long id, @RequestBody UrbanDto urban){
		return urbanService.updateById(id,urban);
	}

	@GetMapping("/findAll")
	public List<UrbanEntity> fetchAll(){
		return urbanRepository.findAll();
	}
}
