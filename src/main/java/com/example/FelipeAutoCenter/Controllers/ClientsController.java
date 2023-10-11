package com.example.FelipeAutoCenter.Controllers;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/clients/all-clients")
    public ResponseEntity showAllClients() {
        List result = clientService.showAllClients();
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/clients/create-client")
    public ResponseEntity receiverInfoClient(@RequestBody ClientsEntities client) throws URISyntaxException {
        clientService.insertClient(client);
        URI baseURL = new URI("http://localhost:8080/clients/exact-client/");
        URI pathExactUser = URI.create(baseURL + client.getId().toString());
        return ResponseEntity.created(pathExactUser).build();
    }

    @PutMapping(path = "/clients/update-client/{id}")
    public ResponseEntity UpdateClient(@PathVariable Long id, @RequestBody ClientsEntities client) {
        Boolean responsePut = clientService.update(id, client);
        if (responsePut) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).body("Client not find");
        }
    }

    @DeleteMapping(path = "/clients/delete-client/{id}")
    public ResponseEntity DeleteClient(@PathVariable Long id) {
        Boolean responseDelete = clientService.delete(id);
        if (responseDelete) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).body("Client not find");
        }
    }
}