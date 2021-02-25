package dev.kiser.services;

import dev.kiser.daos.AccountDAO;
import dev.kiser.daos.ClientDAO;
import dev.kiser.entities.Account;
import dev.kiser.entities.Client;

import java.util.HashSet;
import java.util.Set;

public class AccountService implements AccountServiceIF{

    private final AccountDAO adao;
    private final ClientDAO cdao;

    public AccountService(AccountDAO adao, ClientDAO cdao) {
        this.adao = adao;
        this.cdao = cdao;
    }

    @Override
    // create an account
    public Account registerAccount(int clientId, Account account) {

        // get and set the next id
        Client client  = cdao.getClientById(clientId);
        int accSize = adao.getAllAccounts(client).size();
        account.setClientId(clientId);

        // sets the account id to the number of accounts + 1 that the client has
        if(accSize < client.getAccountNum()) {
            account.setAccId(client.getAccountNum() + 1);
            client.setAccountNum(client.getAccountNum() + 1);
            cdao.updateClientById(client);

        } else {
            // the size larger than the number of client so we set the account id
            // and set the client account num and update the client in the database
            account.setAccId(client.getAccountNum() + 1);

        }

        // create the account
        adao.createAccount(clientId, account);

        return account;
    }

    @Override
    // get all accounts for a client
    public Set<Account> getAllAccounts(int clientId) {
        Client client = cdao.getClientById(clientId);

        // the client does not exist
        if(client == null){
           return null;
        }

        Set<Account> accounts = adao.getAllAccounts(client);
        return accounts;
    }

    @Override
    // get a specific account for the client
    public Account getAccountById(int accId, int clientId) {

        // the client does not exist
        if(cdao.getClientById(clientId) == null){
            return null;
        }

        return adao.getAccountById(accId, clientId);
    }

    @Override
    // get all accounts for a client between a range
    public Set<Account> getAllAccountsByRange(int clientId, float end, float start) {

        Client client = cdao.getClientById(clientId);
        // the client does not exist
        if( client == null){
            return null;
        }

        // get all the accounts for the client
        Set<Account> accounts = adao.getAllAccounts(client);
        Set<Account> accInRange = new HashSet<>();

        // find the accounts between the range
        for (Account acc: accounts) {
            if(acc.getAmount() > start && acc.getAmount() < end){
                accInRange.add(acc);
            }
        }

        // return the accounts in the range
        return accInRange;
    }

    @Override
    // update a specific account for the client
    public Account updateAccountById(Account account, int clientId) {

        // constraints for update are not met or the account doesn't exist
        if(clientId == 0 || account.getAccId() == 0 || account.getType() == null ||
                adao.getAccountById(account.getAccId(), clientId) == null){
            return null;
        }

        return adao.updateAccountById(account, clientId);
    }

    @Override
    // delete a specific account for the client
    public boolean deleteAccountById(int accId, int clientId) {

        // the client does not exist
        if(cdao.getClientById(clientId) == null){
            return false;
        }

        return adao.deleteAccountById(accId, clientId);
    }
}
