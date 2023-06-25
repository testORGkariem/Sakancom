package com.example.sakancom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField userName;
    private static Stage stage;

    private static Scene scene;

    private Parent root;
    @FXML
    protected void onLogin(ActionEvent e) throws IOException {
        //test pushing
        //the flag is to check if theres no matching value in database if no match change the border color to red else change it to black ( the default color )
        int flag=0;
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();



//check if the text field is empty if its empty change the border color to red
            if(userName.getText().isEmpty()==true || Password.getText().isEmpty()==true){
                userName.setStyle("-fx-border-color:red");
                Password.setStyle("-fx-border-color:red");
            }
            else{
                String query = "SELECT * FROM login where username='"+userName.getText()+"'"+" and password='"+Password.getText()+"'";
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    //check if no data
                    if(resultSet.getString(1).isEmpty()==true){
                        flag=0;
                    }
                    else{
                        flag=1;
                        //loading tenant stage
                        if(resultSet.getString(3).equals("tenant")){

                        Parent root = FXMLLoader.load(getClass().getResource("tenant.fxml"));
                        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                        scene=new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        }
                        //loading admin stage
                        else if(resultSet.getString(3).equals("admin")){
                            Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                            stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                            scene=new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }
                        //loading owner stage
                        else if(resultSet.getString(3).equals("owner")){
                            Parent root = FXMLLoader.load(getClass().getResource("owner.fxml"));
                            stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                            scene=new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }
                        else{
                            return;
                        }


                    }
                }

            }


           if(flag==0){
               userName.setStyle("-fx-border-color: red ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");
               Password.setStyle("-fx-border-color: red ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");

           }
           else {
               flag=0;
               userName.setStyle("-fx-border-color: black ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");
               Password.setStyle("-fx-border-color: black ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");
           }

            connection.close();

        } catch (SQLException ex) {
            System.out.println("Failed to connect to the MySQL database!");
            ex.printStackTrace();
        }
        //


    }

    public void Signup(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}