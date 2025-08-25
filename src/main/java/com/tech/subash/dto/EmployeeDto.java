package com.tech.subash.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private String employeeName;
    private String employeeId;
    private Dept dept;
    private String employeeType;


    @Data
    public static  class Dept {
        private String deptName;
    }
}
