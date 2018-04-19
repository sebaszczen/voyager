package trips.repositories;

import org.springframework.data.repository.CrudRepository;
import trips.domain.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {
}
