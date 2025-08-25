package com.tech.subash.controller.nplusone;

import com.tech.subash.dto.CustomDTO;
import com.tech.subash.entity.jpa.StaffEntity;
import com.tech.subash.entity.jpa.StaffOneEntity;
import com.tech.subash.repository.StaffOneRepository;
import com.tech.subash.repository.StaffRepository;
import com.tech.subash.service.LazyLoadingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
@Slf4j
public class LazyLoadingContoller {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private LazyLoadingService lazyLoadingService;

    @Autowired
    private StaffOneRepository staffOneRepository;

    @GetMapping("/get/{id}")
    public StaffEntity findById(@PathVariable("id") int id) {
        StaffEntity staff = staffRepository.findById(id).get();
        log.info("staff Details  77 {} ", staff); // 2 Query For Staff
        // @Data + @ToString  = 2 query For staff
        //log.info("staff Details  Name{} ", staff.getStaffName());  // 2 Query For Here also
        return staff;
    }

    @GetMapping("/lazy/{id}")
    public CustomDTO findByIdLazy(@PathVariable("id") int id) {
        StaffEntity staff = staffRepository.findById(id).get();
        log.info("Staff Details 55 {} ", staff);
        // @Data + @ToString + @JsonIgnore = 2 query
        // @Data + @ToString  = 2 query
        return new CustomDTO(staff.getId(), staff.getStaffName(), staff.getNoOfExpeience());
    }

    @GetMapping("/lazy1/{id}")
    public StaffEntity findByIdLazyOne(@PathVariable("id") int id) {
        StaffEntity staff = staffRepository.findById(id).get();
        log.info("Staff Details {} ", staff.getStaffName());
        // @Data + @ToString + @JsonIgnore = 1 query
        // @Data + @ToString = 1 query
        return staff;
    }

    @GetMapping("/lazy3/{id}")
    public void testToString(@PathVariable int id) {
        StaffOneEntity staff = staffOneRepository.findById(id).get();
        log.info("Logging staff: {}", staff);
        // @Data + @ToString + @JsonIgnore = 1 query
        // @Data + @ToString  = 1 query
    }

    @GetMapping("/lazy2/{id}")
    public StaffEntity lazyLoadingOne(@PathVariable("id") int id) {
        return lazyLoadingService.customDTOSLogOne(id);
    }

    @GetMapping("/lazy4/{id}")
    public CustomDTO customDTOSLogOne(@PathVariable int id) {
        return lazyLoadingService.customDTOSLogTwo(id);
    }

    @GetMapping("/lazy5/{id}")
    public CustomDTO customDTOSLogTwo(@PathVariable int id) {
        return lazyLoadingService.customDTOSLogThree(id);
    }
}
