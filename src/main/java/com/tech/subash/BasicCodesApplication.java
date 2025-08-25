package com.tech.subash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableCaching
//@EnableAsync
@SpringBootApplication

/*@ComponentScan(
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ObjectMapperController.class})
)
@ComponentScan(
		excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.example.exclude.*")
)*/
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class BasicCodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicCodesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return  new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8085/")
						.allowedMethods("GET", "POST","DELETE","PUT")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};

	}

}

/*
 mvn dependency:purge-local-repository
 mvn spring-boot:run
 mvn clean package -DskipTests => generate JAR file inside target
 mvn javadoc:javadoc => to generate javaDoc/ reports/index-all.html
 Remove-Item -Recurse -Force target => MojoFailureException

 to Run Jar
 /target
 inside => java -jar filename.jar

 start

 For stop: ctrl+c
 another way:
    windows powershell
    -----------------
    > Get-Process java
    > Stop-Process -Id <PID> -Force

    in terminal
    ----------
    tasklist | findstr java
    taskkill /PID 8652 /F
 */