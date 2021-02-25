package dev.kiser.services;

import dev.kiser.entities.Client;

import java.util.Set;

public interface ClientServiceIF {

    // CREATE
    Client registerClient(Client client);

    // READ
    Set<Client> getAllClients();
    Client getClientById(int clientId);

    //UPDATE
    Client updateClientById(Client client);

    // DELETE
    boolean deleteClientById(int clientId);
}
