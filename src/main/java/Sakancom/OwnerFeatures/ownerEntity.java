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
    String UserName,Password,Role;
    String owner_username, description, services, price, balcony, numOfBathrooms, floors, residenceName;

    public String addHousing(String ownerUsername, String description, String services, String price, String balcony, String numOfBathrooms, int floors, String residenceName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            String query = "insert into department (username_of_owner, residence_location_desc, services, rent_price, balcony, num_of_bathrooms, pic_file, floors, residenceName) values ('"+ownerUsername+"', '"+description+"', '"+services+"', '"+price+"', '"+balcony+"', '"+numOfBathrooms+"', ?, '"+floors+"', '"+residenceName+"')";
            PreparedStatement statement = connection.prepareStatement(query);
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            statement.setInt(1, 1);
            statement.setBinaryStream(1, fis, fis.available());
            statement.executeUpdate();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
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

    public boolean showHousings()
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement();
            String query = "Select * from housing";
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