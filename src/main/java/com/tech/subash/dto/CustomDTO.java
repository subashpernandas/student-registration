package com.tech.subash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomDTO {
    private int id;
    private String staffName;
    private int noOfExpeience;
}
