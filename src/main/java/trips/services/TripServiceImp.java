package trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trips.domain.Client;
import trips.domain.Trip;
import trips.repositories.ClientRepository;
import trips.repositories.TripRepository;

import java.util.List;

@Service
public class TripServiceImp implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Trip> displayAllTrips() {
        return (List<Trip>) tripRepository.findAll();
    }

    @Override
    public void addTrip(Trip trip, Long id) {
        Client client = clientRepository.findOne(id);
        trip.getClients().add(client);

        tripRepository.save(trip);
        client.setTrip(trip);
        clientRepository.save(client);
    }

    @Override
    public void removeTrip(Long id) {
        tripRepository.delete(id);
    }

    @Override
    public void updateTrips(Trip trip) {
        tripRepository.save(trip);
    }
}
