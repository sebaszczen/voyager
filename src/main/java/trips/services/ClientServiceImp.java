package trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trips.domain.Client;
import trips.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> displayAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void removeClient(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public void clientsUpdate(Client client) {
        clientRepository.save(client);
    }
}
