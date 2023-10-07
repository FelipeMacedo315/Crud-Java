package com.example.FelipeAutoCenter.Controllers;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.web.util.UriComponentsBuilder.fromUri;

@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/create-client")
    public ResponseEntity receiverInfoClient(@RequestBody ClientsEntities client) throws URISyntaxException {
        URI response = clientService.insertClient(client);
        return ResponseEntity.created(response).build();

    }

}
