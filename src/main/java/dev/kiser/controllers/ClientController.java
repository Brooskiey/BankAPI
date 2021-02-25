package dev.kiser.controllers;

import com.google.gson.Gson;
import dev.kiser.daos.ClientDaoPostgres;
import dev.kiser.entities.Client;
import dev.kiser.services.ClientService;
import io.javalin.http.Handler;

import java.util.Set;

public class ClientController {

    private ClientService clientService = new ClientService(new ClientDaoPostgres());

    // create a client
    public Handler createClientHandler = (ctx) -> {

        // get the body of the request
        String body = ctx.body();
        Gson gson = new Gson();
        Client client = gson.fromJson(body, Client.class);

        //create the client
        this.clientService.registerClient(client);
        ctx.result("You created a new client");
        ctx.status(201);
    };

    // get all the clients
    public Handler getAllClientsHandler = (ctx) -> {

        // get all the clients
        Set<Client> allClients = this.clientService.getAllClients();

        // send all clients
        Gson gson = new Gson();
        String clientsJSON = gson.toJson(allClients);
        ctx.result(clientsJSON);
        ctx.status(200);
    };

    // get client y ID
    public Handler getClientByIdHandler = (ctx) -> {

        // get client by id
        int id = Integer.parseInt(ctx.pathParam("id"));
        Client client = this.clientService.getClientById(id);

        // client does not exist
        if (client == null) {
            ctx.result("This client does not exist");
            ctx.status(404);
        } else {
            Gson gson = new Gson();
            String clientJSON = gson.toJson(client);
            ctx.result(clientJSON);
            ctx.status(200);
        }
    };

    // update the client by ID
    public Handler updateClientIdHandler = (ctx) -> {

        int id = Integer.parseInt(ctx.pathParam("id"));

        // get the body
        String body = ctx.body();
        Gson gson = new Gson();
        Client clientInfo = gson.fromJson(body, Client.class);

        // client information was not sent
        if (clientInfo == null) {
            ctx.result("Client could not be updated");
            ctx.status(404);
        } else {

            // update the client
            clientInfo.setId(id);
            Client updated = this.clientService.updateClientById(clientInfo);

            // the client does not exist
            if (updated == null) {
                ctx.result("Client could not be updated");
                ctx.status(404);
            } else {
                String client = gson.toJson(updated);
                ctx.result(client);
                ctx.status(200);
            }
        }
    };

    // delete the client by ID
    public Handler deleteClientHandler = (ctx) -> {

        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = this.clientService.deleteClientById(id);

        // the client was deleted
        if (deleted) {
            ctx.result("Client was deleted");
            ctx.status(200);
        } else {
            ctx.result("Client could not be deleted");
            ctx.status(404);
        }
    };
}
