package io.aiven.spring.mysql.customrecipesharingplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "io.aiven.spring.mysql.customrecipesharingplatform.entity")
@EnableJpaRepositories(basePackages = "io.aiven.spring.mysql.customrecipesharingplatform.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

