package com.bda.carrental.services;



import com.bda.carrental.services.mappers.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoMapper dtoMapper;
    private final ClientMapper entityMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                                    ClientDtoMapper mapper,
                                    ClientMapper entityMapper) {
        this.clientRepository = clientRepository;
        this.dtoMapper = mapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public ClientDto add(ClientDto entity) {
        Optional<Client> client = Stream.of(entity).map(entityMapper).findFirst();
        try {

            this.clientRepository.save(client.get());


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return client.map(dtoMapper).orElseThrow();
    }
    //add y update son iguales, por lo tanto el codigo que esta arriba y debajo podrian ser el mismo. Cualquiera funciona
    @Override
    public ClientDto update(ClientDto entity) {
        Optional<Client> client = Stream.of(entity).map(entityMapper).findFirst();
        client.ifPresent(clientRepository::save);
        return client.map(dtoMapper).orElseThrow();
    }

    @Override
    public ClientDto delete(Long id) {
        ClientDto client = this.getById(id);
        if (client != null) {
            Optional<Client> entity = Stream.of(client).map(entityMapper).findFirst();
            entity.ifPresent(clientRepository::delete);
        }
        return client;
    }

    @Override
    public ClientDto getById(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        return client.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<ClientDto> getAll() {
        List<Client> clients = this.clientRepository.findAll();
        return clients
                .stream()
                .map(dtoMapper)
                .toList();
    }
}

