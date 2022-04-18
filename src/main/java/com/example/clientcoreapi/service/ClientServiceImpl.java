package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientRequest;
import com.example.clientcoreapi.model.ClientResponse;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientId(UUID.randomUUID().toString());

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClientEntity clientEntity= modelMapper.map(clientRequest,ClientEntity.class);

        clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest) {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClientEntity clientEntity= modelMapper.map(clientRequest,ClientEntity.class);

        ClientEntity dbEntity=clientRepository.getClientEntitiesByClientId(clientRequest.getClientId());
        clientEntity.setId(dbEntity.getId());

        clientEntity=clientRepository.save(clientEntity);
        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return clientRepository.getClientEntitiesBy().stream().
                map(clientEntity -> modelMapper.map(clientEntity,ClientResponse.class)).
                collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClientById(String clientId) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ClientEntity clientEntity=clientRepository.getClientEntitiesByClientId(clientId);

        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteClientEntityByClientId(clientId);
    }
}
