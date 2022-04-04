package com.example.clientcoreapi.conroller;

import com.example.clientcoreapi.service.ClientService;
import model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
@Autowired
private ClientService clientService;
    @Autowired
    Environment env;
    @PostMapping
    public ClientModel createClient(@Valid @RequestBody ClientModel clientModel) {
        return clientService.createClient(clientModel);
    }

    @PutMapping("/{clientId}")
    public ClientModel updateClient(@PathVariable String clientId, @Valid @RequestBody ClientModel clientModel) {
        return clientService.updateClient(clientId,clientModel);

    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @DeleteMapping("/{clientId}")
    public ClientModel deleteClient(@PathVariable String clientId) {
        return clientService.deleteClient(clientId);

    }
    @GetMapping("/check")
    public String clientCheck (){
        return new String("Client core api is working correctly at " + env.getProperty("local.server.port"));
    }
  }