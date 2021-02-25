package dev.kiser.daos;

import dev.kiser.entities.Account;
import dev.kiser.entities.Client;
import dev.kiser.util.ConnectionUtil;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;

public class AccountDaoPostgres implements AccountDAO {

    Logger logger = Logger.getLogger(AccountDaoPostgres.class);

    @Override
    // create an account in the database
    public Account createAccount(int clientId, Account account) {

        try (Connection conn = ConnectionUtil.createConnection()) {

            String sql = "insert into account (account_id, amount, account_type, client_id) values (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,account.getAccId());
            ps.setFloat(2, account.getAmount());
            ps.setString(3, account.getType());
            ps.setInt(4, clientId);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); // return the value of the generated key
            rs.next(); // move cursor forward
            int key = rs.getInt("account_id");
            account.setAccId(key);

            logger.info("Create account #" + account.getAccId() + " for client #" + clientId);

            return account;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    // Get all the accounts for a client
    public Set<Account> getAllAccounts(Client client) {

        try (Connection conn = ConnectionUtil.createConnection()) {

            String sql = "select * from account where client_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, client.getId());
            ResultSet rs = ps.executeQuery();

            Set<Account> accounts = new HashSet<>();

            // while accounts exist
            while (rs.next()) {

                Account account = new Account();
                account.setClientId(rs.getInt("client_id"));
                account.setAmount(rs.getFloat("amount"));
                account.setAccId(rs.getInt("account_id"));
                account.setType(rs.getString("account_type"));
                accounts.add(account);
            }

            logger.info("Get all accounts for client #" + client.getId());

            return accounts;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // get a clients account by ID
    public Account getAccountById(int accId, int clientId) {

        try (Connection conn = ConnectionUtil.createConnection()) {

            String sql = "select * from account where client_id = ? and account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ps.setInt(2, accId);
            ResultSet rs = ps.executeQuery();


            rs.next(); // move cursor forward
            Account account = new Account();
            account.setClientId(rs.getInt("client_id"));
            account.setAmount(rs.getFloat("amount"));
            account.setAccId(rs.getInt("account_id"));
            account.setType(rs.getString("account_type"));

            logger.info("Get account #" + accId + " for client #" + clientId);

            return account;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // update a clients account by id
    public Account updateAccountById(Account account, int clientId) {

        try (Connection conn = ConnectionUtil.createConnection()) {

            String sql = "update account set amount = ?, account_type = ? where client_id = ? and account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, account.getAmount());
            ps.setString(2, account.getType());
            ps.setInt(3, clientId);
            ps.setInt(4, account.getAccId());
            ps.execute();

            logger.info("Update account #" + account.getAccId() + " for client #" + clientId);

            return account;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // delete a client's account by id
    public boolean deleteAccountById(int accId, int clientId) {

        try (Connection conn = ConnectionUtil.createConnection()) {

            String sql = "delete from account where client_id = ? and account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ps.setInt(2, accId);
            ps.execute();

            logger.info("Delete account #" + accId + " for client #" + clientId);

            return true;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return false;
        }
    }
}
