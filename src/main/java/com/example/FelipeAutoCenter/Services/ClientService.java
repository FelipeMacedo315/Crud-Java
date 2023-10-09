package com.example.FelipeAutoCenter.Services;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientsRepository clientsRepository;

    public void insertClient(ClientsEntities client) {
        clientsRepository.save(client);

    }
    public List showAllClients(){
       return  clientsRepository.findAll();
    }
}
