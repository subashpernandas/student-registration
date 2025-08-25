package com.tech.subash.custom.annotion;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class CustomDeptValidator implements ConstraintValidator<DeptValidator, String> {

    private List<String> deptExists = List.of("IT", "CSE","EEE");

    @Override
    public boolean isValid(String dept, ConstraintValidatorContext constraintValidatorContext) {
        return deptExists.contains(dept);
    }
}

