package dev.kiser.services;

import dev.kiser.entities.Account;
import dev.kiser.entities.Client;

import java.util.Map;
import java.util.Set;

public interface AccountServiceIF {

    // CREATE
    Account registerAccount(int clientId, Account account);

    // READ
    Set<Account> getAllAccounts(int clientId);
    Account getAccountById(int accId, int clientId);
    Set<Account> getAllAccountsByRange(int clientId, float start, float end);

    // UPDATE
    Account updateAccountById(Account account, int clientId);

    // DELETE
    boolean deleteAccountById(int accId, int clientId);
}
