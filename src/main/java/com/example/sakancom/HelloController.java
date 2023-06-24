package com.example.sakancom;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM login";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                welcomeText.setText(welcomeText.getText()+resultSet.getString(1)+" Password : "+resultSet.getString(2)+"\n");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Failed to connect to the MySQL database!");
            e.printStackTrace();
        }
    }

}