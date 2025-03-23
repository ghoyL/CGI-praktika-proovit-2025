package com.example.demo.controller; 

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

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // search flights by departure & arrival
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String departure, @RequestParam String arrival) {
        return flightService.searchFlights(departure, arrival);
    }
    // search flights by date
    public List<Flight> searchFlights(@RequestParam String departure,  @RequestParam String arrival, @RequestParam String date) {
        return flightService.findFlights(departure, arrival, date);
    }

}
