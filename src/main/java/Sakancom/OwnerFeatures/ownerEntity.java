package Sakancom.OwnerFeatures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

import static org.junit.Assert.fail;

public class ownerEntity {

    boolean ownerFlag = false;
    boolean ownerUsername = false;
    boolean ownerPassword = false;

    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

    public String addResidence(String ownerUsername, String description, String services, String price, String balcony, String numOfBathrooms, int floors, String residenceName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            String query = "insert into department (username_of_owner, residence_location_desc, services, rent_price, balcony, num_of_bathrooms, pic_file, floors, residenceName) values ('"+ownerUsername+"', '"+description+"', '"+services+"', '"+price+"', '"+balcony+"', '"+numOfBathrooms+"', ?, '"+floors+"', '"+residenceName+"')";
            PreparedStatement statement = connection.prepareStatement(query);
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            statement.setInt(1, 1);
            statement.setBinaryStream(2, fis, fis.available());
            statement.executeUpdate();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean ownerLoggedIn(String Username, String Password) {
        System.out.println("_____________________________________________");
        System.out.println("Choose from the following ");
        System.out.println("1-Login");
        System.out.println("2-Signup");
        System.out.print("The Value: ");
        System.out.println("_____________________________________________");
        System.out.println("Username: '"+Username+"'");
        System.out.println("Password: '"+Password+"'");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from login where username = '"+Username+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                if (Username.equals(resultSet.getString("username"))) {
                    ownerUsername = true;
                }
                if (Password.equals(resultSet.getString("password"))) ;
                {
                    ownerPassword = true;
                    if (ownerUsername) {
                        ownerFlag = true;
                    }
                }
            } else {
                fail();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ownerFlag;
    }

    public void ownerDashboard(String Username)
    {
        System.out.println("_____________________________________________");
        System.out.println("____________Welcome '"+Username+"'___________");
        System.out.println("Choose from the following ");
        System.out.println("1-Housing ");
        System.out.println("2-Logout ");
        System.out.println("_____________________________________________");
        System.out.println("___________________Housing___________________ ");
        System.out.println("1-Add Residence ");
        System.out.println("2-Show Residences ");
        System.out.println("__________________Residences_________________ ");
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from departments";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println(resultSet.getString("residenceName"));
                System.out.println("    ");
                System.out.println(resultSet.getString("rent_price"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}