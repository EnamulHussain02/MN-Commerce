package com.example.mnshopz.service;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    void addClient(Client client);
}
