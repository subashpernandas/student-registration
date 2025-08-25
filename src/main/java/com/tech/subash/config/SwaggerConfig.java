package com.tech.subash.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi v1VersionAPIS() {
       return GroupedOpenApi.builder().group("v1-apis")
                .pathsToMatch("/v1/**")
                .addOpenApiCustomizer(openApiCustomizer())
                .build();
    }

    @Bean
    public GroupedOpenApi v2VersionAPIS() {
        return GroupedOpenApi.builder().group("v2-apis")
                .pathsToMatch("/v2/**")
                .addOpenApiCustomizer(openApiCustomizer())
                .build();
    }

    private OpenApiCustomizer openApiCustomizer(){
        return openApi -> {
            Info info = new Info().title("student title").description("stduent-registration");
            Contact contact = new Contact().name("subash.ps").email("subashpstallin@gmaill.com").url("dummyurl");
            info.setContact(contact);
            openApi.setInfo(info);
        };
    }
}
