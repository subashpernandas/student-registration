package com.tech.subash.controller;

import com.tech.subash.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.subash.service.CriteriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/object")
@Slf4j
public class ObjectMapperController {

    public ObjectMapperController(){
        System.out.println("ObjectMapperController called");
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CriteriaService criteriaService;

    @PostMapping("/read")
    public EmployeeDto readValues(@RequestBody EmployeeDto employeeDto){
        try {
            String jsonString = objectMapper.writeValueAsString(employeeDto);
            log.info("json String {} ", jsonString);
            Map<String, Object> mapAfterRemove = objectMapper.readValue(jsonString, new TypeReference<>() {});
            mapAfterRemove.remove("employeeId");
            log.info("map after remove 22 {} ", mapAfterRemove);
            EmployeeDto employeeDtoConvertFromJson = objectMapper.readValue(jsonString, EmployeeDto.class);
            log.info("employeeDtoConvertFromJson {} ", employeeDtoConvertFromJson);
            return  employeeDtoConvertFromJson;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/convert")
    public EmployeeDto convertValues(@RequestBody EmployeeDto employeeDto){
        try {
            String jsonString = objectMapper.writeValueAsString(employeeDto);
            log.info("json String From Convert -Value {} ", jsonString);
            Map<String, Object> mapAfterRemove = objectMapper.convertValue(employeeDto, new TypeReference<>() {});
            mapAfterRemove.remove("employeeType");
            log.info("map after remove 11 {} ", mapAfterRemove);
            EmployeeDto employeeDtoConvertFromJson = objectMapper.convertValue(mapAfterRemove, EmployeeDto.class);
            log.info("employeeDtoConvertFrom Json {} ", employeeDtoConvertFromJson);
            return  employeeDtoConvertFromJson;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get")
    public String getAsync() {
        return String.valueOf(criteriaService.hashCode());
    }
}
