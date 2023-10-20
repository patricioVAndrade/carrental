package com.bda.carrental.services.mappers;

import com.bda.carrental.entidades.Client;
import com.bda.carrental.entidades.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class ClientMapper implements Function<ClientDto, Client> {
    @Override
    public Client apply(ClientDto clientDto) {
        return new Client(clientDto.getId(),
                clientDto.getFirstName(),
                clientDto.getLastName(),
                clientDto.getSex(),
                clientDto.getBirthDate(),
                clientDto.getCompany(),
                new ArrayList<>());

    }
}
