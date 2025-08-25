package com.tech.subash.custom.annotion;


import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class ValidationTest {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        UserDto dto = new UserDto();
        dto.setUsername("subash");
        //dto.setDisplayName("subash.pernandas");

        // Validate only Create group
        System.out.println("--- CREATE group ---");
        Set<ConstraintViolation<UserDto>> violations = validator.validate(dto, ValidationGroups.Create.class);
        for (ConstraintViolation<UserDto> v : violations) {
            System.out.println(v.getMessage() + " | Payload: " + v.getConstraintDescriptor().getPayload());
        }

         //Validate only Update group
        System.out.println("\n--- UPDATE group ---");
        Set<ConstraintViolation<UserDto>> violationsUpdate = validator.validate(dto, ValidationGroups.Update.class);
        for (ConstraintViolation<UserDto> v : violationsUpdate) {
            System.out.println(v.getMessage() + " | Payload: " + v.getConstraintDescriptor().getPayload().toString());
        }
    }
}
