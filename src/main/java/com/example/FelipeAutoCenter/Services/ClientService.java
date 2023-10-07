package com.example.FelipeAutoCenter.Services;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;


@Service
public class ClientService {

    @Autowired
    private ClientsRepository clientsRepository;

    public URI insertClient(ClientsEntities client) throws URISyntaxException {
        URI location = new URI("http://localhost:8080/");
        clientsRepository.save(client);
        return location;


    }
}
