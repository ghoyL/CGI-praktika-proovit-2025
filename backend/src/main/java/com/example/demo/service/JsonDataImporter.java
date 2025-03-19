package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.models.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;

@Service
public class JsonDataImporter {

    private final FlightRepository flightRepository;

    @Autowired
    public JsonDataImporter(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void importFlightsFromJson(InputStream inputStream) throws IOException {  // ✅ Accept InputStream
        ObjectMapper objectMapper = new ObjectMapper();
        
        List<Flight> flights = objectMapper.readValue(inputStream, 
            objectMapper.getTypeFactory().constructCollectionType(List.class, Flight.class));
        /*  for (Flight flight : flights) {
        System.out.println("Parsed Flight: " + flight.getAirline() + ", " + flight.getFlightNumber() + 
            ", " + flight.getDeparture() + " -> " + flight.getArrival() + ", " + flight.getDate());
        } */

        flightRepository.saveAll(flights);  // ✅ Save to DB
        System.out.println("Imported " + flights.size() + " flights.");
    }
}
