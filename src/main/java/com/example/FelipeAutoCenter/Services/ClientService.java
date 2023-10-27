package com.example.FelipeAutoCenter.Services;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    ClientsEntities clientsEntities = new ClientsEntities();
    @Autowired
    private ClientsRepository clientsRepository;

    public void insertClient(ClientsEntities client) {
        clientsRepository.save(client);

    }

    public List showAllClients() {
        return clientsRepository.findAll();
    }

    public Boolean update(Long id, ClientsEntities client) {
        Optional<ClientsEntities> checkExist = clientsRepository.findById(id);
        if (checkExist.isPresent()) {
            client.setId(id);
            clientsRepository.save(client);
            return true;
        } else {
            return false;
        }
    }

    public Boolean delete(Long id) {
        Optional<ClientsEntities> checkExist = clientsRepository.findById(id);
        if (checkExist.isPresent()) {
            clientsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
