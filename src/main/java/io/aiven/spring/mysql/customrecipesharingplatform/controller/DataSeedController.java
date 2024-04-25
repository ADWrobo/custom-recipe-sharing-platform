package io.aiven.spring.mysql.customrecipesharingplatform.controller;

import io.aiven.spring.mysql.customrecipesharingplatform.seeder.DataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DataSeedController {

    @Autowired
    private DataSeeder seeder;

    @PostMapping("/seed")
    public ResponseEntity<String> seedDatabase() {
        seeder.seedDatabase();
        return ResponseEntity.ok("Database seeded successfully!");
    }
}
