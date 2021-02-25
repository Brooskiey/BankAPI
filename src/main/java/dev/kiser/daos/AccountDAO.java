package dev.kiser.daos;

import dev.kiser.entities.Account;
import dev.kiser.entities.Client;

import java.util.Map;
import java.util.Set;

public interface AccountDAO {

    // CREATE
    Account createAccount(int clientId, Account account);

    // READ
    Set<Account> getAllAccounts(Client client);
    Account getAccountById(int accId, int clientId);

    // UPDATE
    Account updateAccountById(Account account, int ClientId);

    // DELETE
    boolean deleteAccountById(int accId, int clientId);
}
