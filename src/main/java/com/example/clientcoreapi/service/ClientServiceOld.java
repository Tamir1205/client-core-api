package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientModel;

import java.util.List;

public interface ClientServiceOld {
    ClientModel createClient(ClientModel clientModel);
    ClientModel updateClient(String clientId,ClientModel clientModel);
    ClientModel getClientById(String clientId);
    List<ClientModel> getAllClients();
    ClientModel deleteClient(String clientId);
}
