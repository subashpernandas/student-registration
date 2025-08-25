package com.tech.subash.dto;


import com.tech.subash.custom.annotion.DeptValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @NotNull(message = "name should not be empty")
    @Size(min = 2, max = 26)
    private String name;
    @Min(value =18, message ="age must be less than 18")
    @Max(value = 60, message = "value can be greater than 60")
    private int age;
    @Email
    private String email;
    @Digits(integer = 5, fraction =2)
    private double salary;

    @DeptValidator(message = "Override message this is only expose")
    private String dept;
}
