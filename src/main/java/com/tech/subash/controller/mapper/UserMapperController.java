package com.tech.subash.controller.mapper;

import com.tech.subash.dto.EmployeeDto;
import com.tech.subash.dto.UserDto;
import com.tech.subash.map.struct.EmployeeMapper;
import com.tech.subash.map.struct.UserMapper;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/user")
public class UserMapperController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/post")
    public UserDto userDto(@RequestBody UserDto userDto){
       userRepository.save(userMapper.convertFromUserDto(userDto));
       return  userDto;
    }

    @GetMapping("/{id}")
    public UserDto userEntity(@PathVariable long id){
        return userMapper.convertFromUserEntity(userRepository.findById(id).get());
    }

    @PostMapping("/employee/post")
    public EmployeeDto employeeDto(@RequestBody EmployeeDto employeeDto){
        employeeRepository.save(employeeMapper.convertFromDTO(employeeDto));
        return employeeDto;
    }
}
