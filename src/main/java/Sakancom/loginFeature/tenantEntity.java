package Sakancom.loginFeature;

import java.sql.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class tenantEntity {
    String firstName, secondName, lastName, phoneNumber, Email, Age, registrationNumber, Major, userName, Password, fullProfile;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    tenantEntity() {

    }

    public void Start() {

    }
    public ResultSet connectDB(String Query)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password))
        {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from login where username = '"+userName+"'";
            ResultSet resultSet=statement.executeQuery(query);
            return resultSet;

        }
        catch (SQLException e)
        {

        }
        return null;
    }
    public void print(String firstName, String secondName, String lastName, String phoneNumber, String Email, String Age, String registrationNumber, String Major, String userName, String Password)
    {


    }
}
