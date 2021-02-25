package dev.kiser.daos;

import dev.kiser.entities.Client;
import dev.kiser.util.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ClientDaoPostgres implements ClientDAO{

    Logger logger = Logger.getLogger(AccountDaoPostgres.class);

    @Override
    // create a new client
    public Client createClient(Client client) {

        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into client (first_name, last_name, marital_status, gender, num_of_accounts) values (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getMaritalStatus());
            ps.setBoolean(4, client.isMale());
            ps.setInt(5, client.getAccountNum());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next(); // move cursor forward
            int key = rs.getInt("client_id");
            client.setId(key);

            logger.info("Create client #" + client.getId());

            return client;

        } catch (SQLException sqlException){
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // get all the clients
    public Set<Client> getAllClients() {

        try(Connection conn = ConnectionUtil.createConnection()){

            String sql = "select * from client";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Set<Client> clients = new HashSet<>();

            // while there are clients
            while(rs.next()) {

                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setMaritalStatus(rs.getInt("marital_status"));
                client.setGender(rs.getBoolean("gender"));
                client.setAccountNum(rs.getInt("num_of_accounts"));
                clients.add(client);
            }

            logger.info("Get all clients");

            return clients;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // get a client by id
    public Client getClientById(int clientId) {

        try(Connection conn = ConnectionUtil.createConnection()){

            String sql = "select * from client where client_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,clientId);
            ResultSet rs = ps.executeQuery();
            rs.next(); // move cursor forward

            Client client = new Client();
            client.setId(rs.getInt("client_id"));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));
            client.setMaritalStatus(rs.getInt("marital_status"));
            client.setGender(rs.getBoolean("gender"));
            client.setAccountNum(rs.getInt("num_of_accounts"));


            logger.info("Get client #" + clientId);

            return client;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // update client by id
    public Client updateClientById(Client client) {

        try(Connection conn = ConnectionUtil.createConnection()) {
            // sql using nice prepared statements
            // write a string and just update the string directly
            String sql = "update client set first_name = ?, last_name = ?, marital_status = ?, gender = ?, num_of_accounts = ? where client_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getMaritalStatus());
            ps.setBoolean(4, client.isMale());
            ps.setInt(5, client.getAccountNum());
            ps.setLong(6, client.getId());

            ps.execute();

            logger.info("Update client #" + client.getId());

            return client;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return null;
        }
    }

    @Override
    // delete client with id
    public boolean deleteClientById(int clientId) {

        try(Connection conn = ConnectionUtil.createConnection()) {

            String sql = "delete from client  where client_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,clientId);
            ps.execute();

            logger.info("Delete client #" + clientId);

            return true;

        } catch (SQLException sqlException) {
            logger.info(sqlException.getStackTrace());
            return false;
        }
    }
}
