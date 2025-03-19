package com.example.demo.controller; // Handle HTTP requests

import com.example.demo.models.Flight;
import com.example.demo.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController  
@RequestMapping("/api/flights")  
@CrossOrigin(origins = "http://localhost:5173") 
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // get all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Search flights by departure & arrival
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String departure, @RequestParam String arrival) {
        return flightService.searchFlights(departure, arrival);
    }

    // Add a new flight
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }
}
