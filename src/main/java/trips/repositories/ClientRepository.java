package trips.repositories;

import org.springframework.data.repository.CrudRepository;
import trips.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
