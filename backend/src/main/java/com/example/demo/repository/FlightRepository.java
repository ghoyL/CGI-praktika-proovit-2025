//  provides methods to fetch and manipulate flight data from the database.
package com.example.demo.repository;

import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // find flights by departure & arrival locations
    List<Flight> findByDepartureAndArrival(String departure, String arrival);
    List<Flight> findByDepartureAndArrivalAndDate(String departure, String arrival, String date);
}
