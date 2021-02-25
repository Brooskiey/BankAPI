package dev.kiser.controllers;

import com.google.gson.Gson;
import dev.kiser.daos.AccountDaoPostgres;
import dev.kiser.daos.ClientDaoPostgres;
import dev.kiser.entities.Account;
import dev.kiser.services.AccountService;
import io.javalin.http.Handler;

import java.util.Set;

public class AccountController {

    private AccountService accountService = new AccountService(new AccountDaoPostgres(), new ClientDaoPostgres());


    // create an account
    public Handler createAccountHandler = (ctx) ->{

        int id = Integer.parseInt(ctx.pathParam("id"));
        String body = ctx.body();

        // get the body into POJO format
        Gson gson = new Gson();
        Account account = gson.fromJson(body, Account.class);

        // register the account
        this.accountService.registerAccount(id, account);

        //return values
        ctx.result("You created a new account");
        ctx.status(201);
    };

    // get all accounts and accounts of a range
    public Handler getAllAccountsHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        String amountLessContains = ctx.queryParam("amountLessThan", "NONE");
        String amountGreaterContains = ctx.queryParam("amountGreaterThan", "NONE");

        // get all the accounts
        if(amountLessContains.equals("NONE") || amountGreaterContains.equals("NONE")) {
            Set<Account> allClients = this.accountService.getAllAccounts(id);

            // there are no accounts
            if(allClients == null) {
                ctx.result("No client or account was found");
                ctx.status(404);
            } else {
                Gson gson = new Gson();
                String accountJSON = gson.toJson(allClients);
                ctx.result(accountJSON);
                ctx.status(200);
            }
        } else {
            // get accounts of a range
            int less = Integer.parseInt(amountLessContains);
            int greater = Integer.parseInt(amountGreaterContains);
            Set<Account> accountsByRange = this.accountService.getAllAccountsByRange(id, less, greater);

            // the client exists and has accounts
            if(accountsByRange != null) {
                Gson gson = new Gson();
                String accountJSON = gson.toJson(accountsByRange);
                ctx.result(accountJSON);
                ctx.status(200);
            } else {
                ctx.result("No client or account was found");
                ctx.status(404);
            }
        }
    };

    // get account by id
    public Handler getAccountHandler = (ctx) ->{
        int clientId = Integer.parseInt(ctx.pathParam("clientId"));
        int accountId = Integer.parseInt(ctx.pathParam("accId"));
        Account account = this.accountService.getAccountById(accountId, clientId);

        // the client or account does not exist
        if(account == null){
            ctx.result("No client or account was found");
            ctx.status(404);
        } else {
            Gson gson = new Gson();
            String accountJSON = gson.toJson(account);
            ctx.result(accountJSON);
            ctx.status(200);
        }

    };

    // update the account
    public Handler updateAccountHandler = (ctx) ->{
        int clientId = Integer.parseInt(ctx.pathParam("clientId"));
        int accountId = Integer.parseInt(ctx.pathParam("accId"));

        // get the body of the requests
        String body = ctx.body();
        Gson gson = new Gson();
        Account account = gson.fromJson(body, Account.class);

        //update the account
        Account account1 = this.accountService.updateAccountById(account, clientId);

        // the account to update exists
        if(account1 == null){
            ctx.result("Client or account could not be updated");
            ctx.status(404);
        } else {
            account1.setClientId(clientId);
            account1.setAccId(accountId);
            String accountJSON = gson.toJson(account1);
            ctx.result(accountJSON);
            ctx.status(200);
        }
    };

    public Handler deleteAccountHandler = (ctx) ->{

        int clientId = Integer.parseInt(ctx.pathParam("clientId"));
        int accountId = Integer.parseInt(ctx.pathParam("accId"));

        // delete the account
        boolean deleted = this.accountService.deleteAccountById(accountId, clientId);

        // the account was deleted
        if(deleted){
            ctx.result("Account was deleted");
            ctx.status(200);
        } else {
            ctx.result("Account could not be deleted");
            ctx.status(404);
        }
    };
}
