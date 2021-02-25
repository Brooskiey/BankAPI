package dev.kiser.daos;


import dev.kiser.entities.Account;
import dev.kiser.entities.Client;

import java.util.HashSet;
import java.util.Set;



// IDK IF NEEDED AT THIS MOMENT
public class AccountDaoLocal implements AccountDAO{

    Set<Account> accounts = new HashSet<>();


    @Override
    public Account createAccount(int clientId, Account account) {
        account.setAccId(account.getAccId());
        account.setClientId(clientId);
        accounts.add(account);
        return account;
    }

    @Override
    public Set<Account> getAllAccounts(Client client) {
        return client.getClientAccounts();
    }

    @Override
    public Account getAccountById(int accId, int clientId) {
        for (Account account: accounts) {
            if(account.getAccId() == accId && account.getClientId() == clientId){
                return account;
            }
        }
        return null;
    }

    @Override
    public Account updateAccountById(Account account, int clientId) {
        for (Account acc: accounts) {
            if(acc.getClientId() == clientId && acc.getAccId() == account.getAccId()){
                accounts.remove(acc);
                accounts.add(account);
            }
        }
        return account;

    }

    @Override
    public boolean deleteAccountById(int accId, int clientId) {
        boolean result = accounts.removeIf(acc -> acc.getClientId() == clientId && acc.getAccId() == accId);
        return result;
    }
}
