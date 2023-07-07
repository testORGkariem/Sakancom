package Sakancom.loginFeature;

import java.sql.*;
import static org.junit.Assert.*;

public class loginEntity {

    boolean Owner = false;
    boolean reg = false;
    boolean Tenant = false;
    boolean adminUsername, adminPassword,adminFlag;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

    public boolean printAdmin(String adminUser, String adminPass)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from login where username = '"+adminUser+"'";
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()) {
                if(adminUser.equals(resultSet.getString("username")))
                {
                    adminUsername = true;
                }
                if(adminPass.equals(resultSet.getString("password")));
                {
                    adminPassword = true;
                    if(adminUsername)
                    {
                        adminFlag = true;
                        return true;
                    }
                }
            }
            else {
                fail();
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
        return adminFlag;
    }
    public boolean printOwner(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass) {
        System.out.println("_____________________________________________");
        System.out.println("Choose from the following ");
        System.out.println("1-Login");
        System.out.println("2-Signup");
        System.out.print("The Value : ");
        System.out.println("_____________________________________________");
        String owner = "owner";
        System.out.println("________________Signup as Owner________________");
        System.out.println("Please enter your First name: " + Fname+ "\n");
        System.out.println("Please enter your Middle name name: " + Mname + "\n");
        System.out.println("Please enter your Last name: " + Lname + "\n");
        System.out.println("Please enter your Phone number: " + Phone + "\n");
        System.out.println("Please enter your Email: " + Owemail + "\n");
        System.out.println("Please enter your age: " + age + "\n");
        System.out.println("Please enter your username: " + OwUser + "\n");
        System.out.println("Please enter your password: " + OwPass + "\n");
        System.out.println("_____________________________________________");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement2 = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('"+OwUser+"', '"+OwPass+"', '"+owner+"')";
            statement2.executeUpdate(query2);
            Statement statement3 = connection.createStatement();
            String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('"+Fname+"', '"+Mname+"', '"+Lname+"', '"+Phone + "', '"+Owemail+"', '"+age+"', '"+OwUser+"', '"+OwPass+"', '"+owner+"')";
            statement3.executeUpdate(query3);
            System.out.println("Creating Owner Account...");
            System.out.println("_____________________________________________");
            Owner = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Owner;
    }

    public boolean printTenant( String FFname, String MMname, String LLname, String PPhone, String tenemail, String Age, String Reg_num, String major, String tenUser, String tenPass) {
        System.out.println("________________Signup as Tenant________________");
        String tenant = "tenant";
        System.out.println("Please enter your First name: "+FFname+"\n");
        System.out.println("Please enter your Middle name name: "+MMname+"\n");
        System.out.println("Please enter your Last name: "+LLname+"\n");
        System.out.println("Please enter your Phone number: "+PPhone+"\n");
        System.out.println("Please enter your Email: "+tenemail+"\n");
        System.out.println("Please enter your age: "+Age+"\n");
        System.out.println("Please enter your Registration number: "+Reg_num+"\n");
        System.out.println("Please enter your major: "+major+"\n");
        System.out.println("Please enter your username: "+tenUser+"\n");
        System.out.println("Please enter your password: "+tenPass+"\n");
        System.out.println("_____________________________________________");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement3 = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('"+tenUser+"','"+tenPass+"', '"+tenant+"')";
            statement3.executeUpdate(query3);
            Statement statement4 = connection.createStatement();
            String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('" + FFname + "', '" + MMname + "', '" + LLname + "', '" + PPhone + "', '" + tenemail + "', '" + Age + "', '" + Reg_num + "', '" + major + "', '" + tenUser + "','" + tenPass + "', '" + tenant + "')";
            statement4.executeUpdate(query4);
            System.out.println("Creating Tenant Account...");
            System.out.println("_____________________________________________");
            Tenant = true;
            }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Tenant;
    }
    public void logout()
    {
        System.out.println("_____________________________________________");
        System.out.println("Choose from the following ");
        System.out.println("7-logout");
        System.out.print("The Value : ");
        System.out.println("_____________________________________________");
        System.out.println("\n******* information *******\n");
        System.out.println("_____________________________________________");
        System.out.println("___________Logged out Successfully___________");
        System.out.println("_____________________________________________");
    }
    public boolean failureReg(String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass) {
        System.out.println("________________Signup as Tenant________________");
        String tenant = "tenant";
        System.out.println("Please enter your First name: "+FFname+"\n");
        System.out.println("Please enter your Middle name name: "+MMname+"\n");
        System.out.println("Please enter your Last name: "+LLname+"\n");
        System.out.println("Please enter your Phone number: "+PPhone+"\n");
        System.out.println("Please enter your Email: "+tenmail+"\n");
        System.out.println("Please enter your age: "+Age+"\n");
        System.out.println("Please enter your Registration number: "+Reg_num+"\n");
        System.out.println("Please enter your major: "+major+"\n");
        System.out.println("Please enter your username: "+tenUser+"\n");
        System.out.println("Please enter your password: "+tenPass+"\n");
        System.out.println("_____________________________________________");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "select * from login where username = '"+tenUser+"'and password = '"+tenPass+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reg;
    }

}

