package com.tech.subash.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {

    private String name;
    private Security security = new Security();

    @Data
    public static class Security {
        private boolean enabled;
        private String role;
    }

}
