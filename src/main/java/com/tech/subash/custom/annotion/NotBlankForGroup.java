package com.tech.subash.custom.annotion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankForGroupValidator.class)
@Documented
public @interface NotBlankForGroup {

    // ① Default message (can be overridden)
    String message() default "Value must not be blank";

    // ② Validation groups
    Class<?>[] groups() default {};

    // ③ Payload (metadata)
    Class<? extends Payload>[] payload() default {};
}
