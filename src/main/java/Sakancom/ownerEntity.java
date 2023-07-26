package Sakancom;

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
    int counter = 50;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String UserName,Password,Role;
    String owner_username, description, services, price, balcony, numOfBathrooms, floors, residenceName;

    public boolean addHousing(String ownerUsername) throws SQLException {
        counter++;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "insert into housing (owner, id) values ('"+ownerUsername +"', '"+counter+"')";
            statement.executeUpdate(query);
            return true;
        }
    }
    public boolean addPhoto(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE housing SET picture = ? WHERE id = '"+counter+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            statement.setInt(1, 1);
            statement.setBinaryStream(1, fis, fis.available());
            statement.executeUpdate();
            return true;
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addLocationInfo(String location){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET location = '"+location+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addServices(String services){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET services = '"+services+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addPrice(String price){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET price = '"+price+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addContactInfo(String owner){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET price = '"+price+"' WHERE id = '"+counter+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){

            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  String checkValues(String UserName,String Password) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            if (UserName.isEmpty() == true || Password.isEmpty() == true) {
            } else {
                int flag = 0;
                String query = "SELECT * FROM login where username='" + UserName + "'" + " and password='" + Password + "'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    flag = 1;
                    if (resultSet.getString(3).equals("tenant")) {
                        Role=new String("tenant");
                        return Role;
                    } else if (resultSet.getString(3).equals("admin")) {
                        Role=new String("admin");
                        return Role;
                    } else if (resultSet.getString(3).equals("owner")) {
                        Role=new String("owner");
                        return Role;
                    } else {
                        Role=new String("null");
                        return Role;
                    }
                }
                if (flag == 0) {
                    Role=new String("null");
                    return Role;
                }
            }
        } catch (Exception ex) {
        }
        return Role;
    }

    public boolean showHousings(String owner)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement();
            String query = "Select * from housing where owner = '"+owner+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("ID : " + resultSet.getString(8));
                System.out.println("Picture : " + resultSet.getString(1));
                System.out.println("Price : " + resultSet.getString(2));
                System.out.println("Location : " + resultSet.getString(3));
                System.out.println("Services : " + resultSet.getString(4));
                System.out.println("Number of people lived in : " + resultSet.getString(11));
                System.out.println("Floor Number: " + resultSet.getString(9));
                System.out.println("Department Name : " + resultSet.getString(10));
                return true;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean checkHousings()
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement();
            String query = "Select * from housing where departmentName ";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println(resultSet.getString("residenceName"));
                System.out.println("    ");
                System.out.println(resultSet.getString("rent_price"));
                return true;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}