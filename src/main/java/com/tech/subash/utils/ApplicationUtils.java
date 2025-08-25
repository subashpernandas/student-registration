package com.tech.subash.utils;

import org.springframework.stereotype.Component;

@Component
public class ApplicationUtils {

    public static String getUtilCalls(){
        return "Util-Call";
    }

    public static boolean isValid(String utilCallReturn) {
        return utilCallReturn.toUpperCase().equals("UTIL-CALL");
    }

    public  String getUtilCallsWith(){
        return "subash.ps";
    }
}
