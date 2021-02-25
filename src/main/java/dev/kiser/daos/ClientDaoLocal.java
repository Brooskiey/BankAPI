package dev.kiser.daos;

import dev.kiser.entities.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientDaoLocal implements ClientDAO{

    private int idMaker = 0;
    private final Map<Integer, Client> clientsTable = new HashMap<>();

    @Override
    public Client createClient(Client client) {
        client.setId(++idMaker);
        clientsTable.put(client.getId(), client);
        return client;
    }

    @Override
    public Set<Client> getAllClients() {
        return new HashSet<Client>(this.clientsTable.values());
    }

    @Override
    public Client getClientById(int clientId) {
        return clientsTable.get(clientId); // placeholder until html codes are implemented
    }

    @Override
    public Client updateClientById(Client client) {
        clientsTable.put(client.getId(), client);
        return client;
    }

    @Override
    public boolean deleteClientById(int clientId) {
        Client client = clientsTable.remove(clientId);
        if(client == null){
            return false;
        }
        return true;
    }
}
