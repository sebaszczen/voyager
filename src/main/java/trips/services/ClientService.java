package trips.services;

import trips.domain.Client;

import java.util.List;

public interface ClientService {
    List<Client> displayAllClients();
    void addClient(Client client);
    void removeClient(Long id);
    void clientsUpdate(Client client);
}
