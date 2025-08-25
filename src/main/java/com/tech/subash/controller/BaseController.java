package com.tech.subash.controller;


import com.tech.subash.response.CommonResponse;

public class BaseController {

    private static final String SUCCESS_CODE = "0";
    private static final String SVC = "student-registration";

    protected CommonResponse successResponse(String  status, String svc, String svcName, String infoId, Object data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSvc(svc);
        commonResponse.setSvcName(svcName);
        commonResponse.setInfoId(infoId);
        commonResponse.setData(data);
        commonResponse.setStatus(status);
        return commonResponse;
    }


    protected CommonResponse successResponse(String svcName, String infoId, Object data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSvcName(svcName);
        commonResponse.setInfoId(infoId);
        commonResponse.setData(data);
        commonResponse.setSvc(SVC);
        commonResponse.setStatus(SUCCESS_CODE);
        return commonResponse;
    }
}
