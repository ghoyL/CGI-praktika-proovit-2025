package com.example.demo;

import com.example.demo.service.JsonDataImporter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.io.IOException;

@Component
public class ImportFlights implements CommandLineRunner {  

    private final JsonDataImporter jsonDataImporter;

    @Autowired
    public ImportFlights(JsonDataImporter jsonDataImporter) {
        this.jsonDataImporter = jsonDataImporter;
    }

    @Override
    public void run(String... args) throws IOException {  
        ClassPathResource resource = new ClassPathResource("flights.json");

        try (InputStream inputStream = resource.getInputStream()) { 
            jsonDataImporter.importFlightsFromJson(inputStream);
        }

        System.out.println("Flights imported successfully!");
    }
}
