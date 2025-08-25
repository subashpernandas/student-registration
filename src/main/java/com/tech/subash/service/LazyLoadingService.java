package com.tech.subash.service;

import com.tech.subash.dto.CustomDTO;
import com.tech.subash.entity.jpa.StaffEntity;
import com.tech.subash.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LazyLoadingService {

    @Autowired
    private StaffRepository staffRepository;

    public StaffEntity customDTOSLogOne(int id) {
        StaffEntity staff = staffRepository.findById(id).get();
        log.info("Staff Details {} ", staff.getStaffName());
        // @Data + @ToString + @JsonIgnore = 1 query
        // @Data + @ToString  = 1 query
        return staff;
    }

    public CustomDTO customDTOSLogTwo(int id) {
        StaffEntity staff = staffRepository.findById(id).get();
        log.info("Staff Details {} ", staff);
        // @Data + @ToString + @JsonIgnore = 2 query
        // @Data + @ToString  = 2 query
        return new CustomDTO(staff.getId(),staff.getStaffName(),staff.getNoOfExpeience());
    }

    public CustomDTO customDTOSLogThree(int id) {
        StaffEntity staff = staffRepository.findById(id).get();
        log.info("Staff Details {} ", staff.getStaffName());
        // @Data + @ToString + @JsonIgnore = 1 query
        // @Data + @ToString  = 1 query
        return new CustomDTO(staff.getId(),staff.getStaffName(),staff.getNoOfExpeience());
    }
}
