package Sakancom.loginFeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class loginEntity {

    String UserName,Password,Role;
    public  String checkValues() {

        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter User Name : ");
this.UserName = input1.nextLine();
        System.out.print("Enter the Password : ");
        this.Password = input1.nextLine();

        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            if (UserName.isEmpty() == true || Password.isEmpty() == true) {
                System.out.println("Wrong input");
            } else {
                int flag = 0;
                String query = "SELECT * FROM login where username='" + UserName + "'" + " and password='" + Password + "'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {

                    //check if no data
                    if (resultSet.getString(1).isEmpty() == false) {
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


                }
                if (flag == 0) {
                    Role=new String("null");

                    System.out.println("Theres no user in the system has matching with information you enter, create new account please");
                    return Role;
                }
            }


            connection.close();
        } catch (Exception ex) {
            System.out.println("Failed to connect to the MySQL database!");
            ex.printStackTrace();
        }




        return Role;
    }


}
