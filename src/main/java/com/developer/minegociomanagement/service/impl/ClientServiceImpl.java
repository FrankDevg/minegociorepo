package com.developer.minegociomanagement.service.impl;

import com.developer.minegociomanagement.dto.mapper.AddressClientMapper;
import com.developer.minegociomanagement.dto.mapper.AddressMapper;
import com.developer.minegociomanagement.dto.mapper.ClientMapper;
import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.repository.AddressRepository;
import com.developer.minegociomanagement.repository.ClientRepository;
import com.developer.minegociomanagement.service.interfaces.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public ClientServiceImpl(ClientRepository clientRepository,AddressRepository  addressRepository) {

        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;

    }

    @Override
    public List<ClientEntity> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public ClientEntity saveClient(ClientEntity clientEntity) {

        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

//    Using Request and Response with save and update client

    @Override
    public ClientResponse saveClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        AddressEntity addressEntity = AddressClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        clientRepository.save(clientEntity);
        ClientResponse clientResponse=ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
        addressEntity.setId_cliente(clientResponse.getId_cliente());
        addressRepository.save(addressEntity);
        return clientResponse;
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest, Long id) {

        Optional<ClientEntity> checkExistingClient = findById(id);
        if (! checkExistingClient.isPresent())
            throw new RuntimeException("Client Id "+ id + " Not Found!");

        ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        clientEntity.setId_cliente(id);
        clientRepository.save(clientEntity);
        return ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
    }

}
