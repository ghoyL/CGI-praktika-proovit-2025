// flight-related operations.
package com.example.demo.service;

import com.example.demo.models.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    // get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    // search flights by departure & arrival
    public List<Flight> searchFlights(String departure, String arrival) {
        return flightRepository.findByDepartureAndArrival(departure, arrival);
    }
    // search flights by departure & arrival & date
    public List<Flight> findFlights(String departure, String arrival, String date) {
        return flightRepository.findByDepartureAndArrivalAndDate(departure, arrival, date);
    }

    public void saveFlights(List<Flight> flights) {
        flightRepository.saveAll(flights);
    }
}
