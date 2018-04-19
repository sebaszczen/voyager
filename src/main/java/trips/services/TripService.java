package trips.services;

import trips.domain.Trip;

import java.util.List;

public interface TripService {
    List<Trip> displayAllTrips();
    void addTrip(Trip trip, Long id);
    void removeTrip(Long id);
    void updateTrips(Trip trip);
}
