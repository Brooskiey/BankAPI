package dev.kiser.servicetests;


import dev.kiser.daos.*;
import dev.kiser.entities.Account;
import dev.kiser.entities.Client;
import dev.kiser.services.AccountService;
import dev.kiser.services.ClientService;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceTest {
//
//
//    private static ClientDAO clientDAO = new ClientDaoPostgres();
//    private static AccountService aserv = new AccountService(new AccountDaoPostgres(), clientDAO);
//    private static ClientService cserv = new ClientService(clientDAO);
//    private static Account testAccount = null;
//    private static Client testClient = null;
//
//    @Test
//    @Order(1)
//    void register_account(){
//        Account account = new Account(0,0,0,"Savings");
//        Client client = new Client(0, "Brooke", "Kiser", 0, false,1);
//        cserv.registerClient(client);
//        aserv.registerAccount(client.getId(), account);
//
//        System.out.println("\nregister_account: assertNotEquals" +
//                "\n\tUnexpected: 0" +
//                "\n\tActual: " + account.getAccId());
//        Assertions.assertNotEquals(0, account.getAccId());
//        testAccount = account;
//        testClient = client;
//    }
//
//    @Test
//    @Order(2)
//    void get_all_accounts(){
//
//        Set<Account> accounts =  aserv.getAllAccounts(testClient.getId());
//
//        System.out.println("\nget_all_accounts: assertEquals" +
//                "\n\tExpected size: 1" +
//                "\n\tActual size: " + accounts.size());
//        Assertions.assertEquals(1, accounts.size());
//    }
//
//    @Test
//    @Order(3)
//    void get_account_by_id(){
//        Account account = aserv.getAccountById(testAccount.getAccId(), testClient.getId());
//
//        System.out.println("\nget_account_by_id: assertEquals" +
//                "\nClient ID" +
//                "\n\tExpected: " + testClient.getId() +
//                "\n\tActual: " + account.getClientId());
//        Assertions.assertEquals(testClient.getId(), account.getClientId());
//
//        System.out.println("\nget_account_by_id: assertEquals" +
//                "\nAccount ID" +
//                "\n\tExpected: " + testAccount.getAccId() +
//                "\n\tActual: " + account.getAccId());
//        Assertions.assertEquals(testAccount.getAccId(), account.getAccId());
//    }
//
//    @Test
//    @Order(4)
//    void update_account(){
//        Account account = new Account(0, 6, 0, "Checking");
//        account.setAmount(200);
//        account.setAccId(testAccount.getAccId());
//        aserv.updateAccountById(account, testClient.getId());
//
//        System.out.println("\nupdate_account: assertEquals" +
//                "\n\tExpected: 200" +
//                "\n\tActual: " + account.getAmount());
//        Assertions.assertEquals(200, account.getAmount());
//    }
//
//    @Test
//    @Order(5)
//    void delete_account(){
//        boolean result = aserv.deleteAccountById(testAccount.getAccId(), testClient.getId());
//
//        System.out.println("\ndelete_client: assertTrue" +
//                "\n\tExpected: True" +
//                "\n\tActual: " + result);
//        Assertions.assertTrue(result);
//    }
}
