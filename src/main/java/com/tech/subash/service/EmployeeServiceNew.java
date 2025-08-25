package com.tech.subash.service;

import com.tech.subash.helper.ApplicationHelper;
import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.utils.ApplicationUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceNew {

        private final EmployeeRepository employeeRepository;
        private final ApplicationUtils applicationUtils; // for non-static
        private final ApplicationHelper applicationHelper; // wrapper for static

        public EmployeeServiceNew(EmployeeRepository employeeRepository,
                                  ApplicationUtils applicationUtils,
                                  ApplicationHelper applicationHelper) {
            this.employeeRepository = employeeRepository;
            this.applicationUtils = applicationUtils;
            this.applicationHelper = applicationHelper;
        }

        public List<EmployeeEntity> getAllEmployee() {
            String returnName = applicationHelper.getUtilCalls();
            if ("Util-Call".equals(returnName) && applicationHelper.isValid(returnName)) {
                String name = applicationUtils.getUtilCallsWith();
                if ("subash.ps".equals(name)) {
                    return employeeRepository.findAll();
                }
            } else {
                throw new RuntimeException("exception occured");
            }
            return List.of();
        }
    }

