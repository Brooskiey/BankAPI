package dev.kiser.services;

import dev.kiser.daos.ClientDAO;
import dev.kiser.entities.Client;

import java.util.Set;

public class ClientService implements ClientServiceIF{

    private final ClientDAO cdao;

    public ClientService(ClientDAO cdao) {
        this.cdao = cdao;
    }

    @Override
    // create a client
    public Client registerClient(Client client) {
        return cdao.createClient(client);
    }

    @Override
    // get all the clients
    public Set<Client> getAllClients() {
        return cdao.getAllClients();
    }

    @Override
    // get client by id
    public Client getClientById(int clientId) {
        return cdao.getClientById(clientId);
    }

    @Override
    // update the client by id
    public Client updateClientById(Client client) {

        // update constraints are not met
        if(client.getMaritalStatus() > 3 || client.getFirstName() == null || client.getLastName() == null || client.getId() == 0
                || cdao.getClientById(client.getId()) == null){
            return null;
        }

        return cdao.updateClientById(client);
    }

    @Override
    // delete the client by id
    public boolean deleteClientById(int clientId) {

        // the client does not exist
        if(cdao.getClientById(clientId) == null){
            return false;
        }

        return cdao.deleteClientById(clientId);
    }
}
