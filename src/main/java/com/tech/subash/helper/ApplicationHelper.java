package com.tech.subash.helper;

import com.tech.subash.utils.ApplicationUtils;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHelper {

    public String getUtilCalls() {
        return ApplicationUtils.getUtilCalls(); // static inside wrapper
    }

    public boolean isValid(String value) {
        return ApplicationUtils.isValid(value); // static inside wrapper
    }
}
