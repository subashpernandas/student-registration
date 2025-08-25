package com.tech.subash.custom.annotion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomDeptValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DeptValidator {

    //String message() default "In valid Dept";

   // Class<?>[] groups() default {};

   // Class<? extends Payload>[] payload() default {};


    String message () default  "invalid";

    Class<?>[] groups() default  {};

    Class<? extends  Payload>[] payload() default {};

}
