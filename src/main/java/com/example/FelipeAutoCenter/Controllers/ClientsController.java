package com.example.FelipeAutoCenter.Controllers;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromUri;

@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/clients/create-client")
    public ResponseEntity receiverInfoClient(@RequestBody ClientsEntities client) throws URISyntaxException {
        clientService.insertClient(client);
        URI baseURL = new URI("http://localhost:8080/client/");
        URI pathExactUser = URI.create(baseURL + client.getId().toString());
        return ResponseEntity.created(pathExactUser).build();

    }

    @GetMapping(path = "/clients/all-clients")
    public ResponseEntity showAllClients() {
        List result = clientService.showAllClients();
        return ResponseEntity.ok(result);
    }


}
