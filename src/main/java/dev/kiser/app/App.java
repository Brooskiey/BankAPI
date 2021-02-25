package dev.kiser.app;

import dev.kiser.controllers.AccountController;
import dev.kiser.controllers.ClientController;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        ClientController clientController = new ClientController();
        AccountController accountController = new AccountController();

        // POST /clients => create a new client
        app.post("/clients", clientController.createClientHandler);

        // GET /clients => return all clients
        app.get("/clients", clientController.getAllClientsHandler);

        // GET /clients/10 => get client with ID 10
        app.get("/clients/:id", clientController.getClientByIdHandler);

        // PUT /clients/12 => update client 12
        app.put("/clients/:id", clientController.updateClientIdHandler);

        //DELETE /clients/15 => delete client with the ID 15
        app.delete("/clients/:id", clientController.deleteClientHandler);

//------------------------------------------------------------------------------------------------//

        // POST /clients/5/accounts => create a new account for client #5
        app.post("/clients/:id/accounts", accountController.createAccountHandler);

        // GET /clients/5/accounts => return all accounts for client #7
        // GET /clients/7/accounts?amountLessThan=2000&amountGreaterThan=400 =>
            // get all accounts for client #7 between 400 and 2000
        app.get("/clients/:id/accounts", accountController.getAllAccountsHandler);

        //GET /clients/9/accounts/4 => get account #4 of client #9
        app.get("/clients/:clientId/accounts/:accId", accountController.getAccountHandler);

        // PUT /clients/10/accounts/3 => update account #3 of client #10
        app.put("/clients/:clientId/accounts/:accId", accountController.updateAccountHandler);

        //DELETE /clients/15/accounts/6 => delete account #6 of client #15
        app.delete("/clients/:clientId/accounts/:accId", accountController.deleteAccountHandler);

        app.start(); // actually starts the web server
    }
}
