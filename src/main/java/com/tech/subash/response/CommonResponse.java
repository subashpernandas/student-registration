package com.tech.subash.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private String status;
    private String svc;
    private String svcName;
    private String infoId;
    private Object data;
}
