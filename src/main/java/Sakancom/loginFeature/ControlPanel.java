package Sakancom.loginFeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControlPanel {

    public boolean isBooked(String userName){


        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from booking where tenantUserName='"+userName+"'" ;
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return true;
            }

        }
        catch (Exception e){

        }


            return false;

    }

    public boolean displayBooked(String userName) {
        if (isBooked(userName)) {
            int counter=1;
            String host = "localhost";
            int port = 3306;
            String database = "Sakancom";
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the MySQL database!");
                Statement statement = connection.createStatement();
                String query = new String();

query="select ";


            } catch (Exception e) {
e.printStackTrace();
            }


            return false;
        }
        return false;
    }

    public boolean displayOwnerInfo(String userName){

        return false;
    }

}
