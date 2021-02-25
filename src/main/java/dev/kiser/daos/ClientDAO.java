package dev.kiser.daos;

import dev.kiser.entities.Client;

import java.util.Set;

public interface ClientDAO {

    // CREATE
    Client createClient(Client client);

    // READ
    Set<Client> getAllClients();
    Client getClientById(int clientId);

    //UPDATE
    Client updateClientById(Client client);

    // DELETE
    boolean deleteClientById(int clientId);
}
