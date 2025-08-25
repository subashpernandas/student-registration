package com.tech.subash.thread.completable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericException {
    private String message;
    private int statusCode;
}
