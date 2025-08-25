package com.example.demo.controller;

import com.example.demo.entity.Urban;
import com.example.demo.repository.UrbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private UrbanRepository urbanRepository;


	@GetMapping
	public Student getStudent() {
		return new Student("subash.pernandas.savari",31);
	}

	@PostMapping("/post")
	public void storeUrbanDetails(@RequestBody Urban urban){
		urbanRepository.save(urban);
	}
}
