package dev.kiser.DAOtests;

import dev.kiser.daos.*;
import dev.kiser.entities.Account;
import dev.kiser.entities.Client;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTest {

    private static AccountDAO adao = new AccountDaoPostgres();

    @BeforeEach
    void make_new_account_dao(){
        adao = new AccountDaoPostgres();
    }

    @Test
    @Order(1)
    void create_account(){
        Account account = new Account(0 , 1, 0, "Checking");
        adao.createAccount(1, account);
        System.out.println("\ncreate_account: assertNotEquals" +
                "\n\tUnexpected: 0" +
                "\n\tActual: " + account.getAccId());
        Assertions.assertNotEquals(0, account.getAccId());
    }

    @Test
    @Order(2)
    void get_all_account_good_input(){

        Account account0 = new Account(0,2,0, "Checking");
        Account account1 = new Account(0, 1,0, "Checking");
        Account account2 = new Account(0,1,0, "Checking");

        adao.createAccount(1, account0);
        adao.createAccount(2, account1);
        adao.createAccount(3, account2);

        Client client = new Client(3, "Rhonda", "MacGregor", 1, false, 1);

        Set<Account> accounts = adao.getAllAccounts(client);

        System.out.println("\nget_all_account: assertEquals" +
                "\n\tExpected: 1" +
                "\n\tActual: " + accounts.size());
        Assertions.assertEquals(1, accounts.size());

    }

    @Test
    @Order(3)
    void get_account_by_id_good_input(){

        Account idAccount = adao.getAccountById(2, 1);

        System.out.println("\nget_account_by_id: assertEquals" +
                "\n\tExpected: " + 1 +
                "\n\tActual: " + idAccount.getClientId());
        Assertions.assertEquals(1, idAccount.getClientId());
    }

    @Test
    @Order(4)
    void update_account_by_id_good_input(){

        Account newAcc = new Account(1,2, 200, "Checking");

        Account accList = adao.updateAccountById(newAcc, newAcc.getClientId());

        System.out.println("\nupdate_account_by_id: assertEquals" +
                "\n\tExpected: 200.0" +
                "\n\tActual: " + accList.getAmount());
        Assertions.assertEquals(200.0, accList.getAmount());    }

    @Test
    @Order(5)
    void delete_account_by_id_good_input(){

        boolean result = adao.deleteAccountById(1,1);

        System.out.println("\ndelete_Account_by_id_good_input: assertTrue" +
                "\n\tExpected: true" +
                "\n\tActual: " + result);
        Assertions.assertTrue(result);
    }

}

