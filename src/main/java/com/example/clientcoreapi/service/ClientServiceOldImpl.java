package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceOldImpl implements ClientServiceOld {
    private static HashMap<String, ClientModel> ClientMap = new HashMap<>();

    static {
        ClientModel firstClient = new ClientModel("be6e2e90-967e-48dc-9b7b-23f38921dd68",
                "Tamirlan",
                "Shiderbayev",
                "tamirlan@gmail.com");
        ClientModel secondClient = new ClientModel("84f273a2-f62f-4940-ba68-b0af64088f65",
                "Aldiyar", "Shabdarov",
                "isatay@gmail.com");
        ClientMap.put(firstClient.getClientId(), firstClient);
        ClientMap.put(secondClient.getClientId(), secondClient);
    }

    @Override
    public ClientModel createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        return ClientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public ClientModel updateClient(String clientId, ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        return ClientMap.put(clientId, clientModel);
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return ClientMap.get(clientId);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(ClientMap.values());
    }

    @Override
    public ClientModel deleteClient(String clientId) {
        return ClientMap.remove(clientId);
    }
}
