package com.tech.subash.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CattleDto implements Serializable {
    private String name;
    private String type;
    private int id;
}
