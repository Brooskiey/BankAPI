package dev.kiser.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection createConnection(){

        String details = System.getenv("CONN_DETAILS");

        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://35.196.41.218:5432/BankAPI?user=Brooskiey&password=Brooskiey17!");// a factory. pass in string details for any type of database
            // anywhere and the driverManager factory will give you back a connection implementation specifically for postgres
            return conn;
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            return null;
        }
    }
}
