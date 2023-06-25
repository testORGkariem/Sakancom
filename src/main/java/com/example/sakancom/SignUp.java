package com.example.sakancom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SignUp implements Initializable {
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private TextField Age;

    @FXML
    private TextField Email;
    @FXML
    private TextField Phone;
    @FXML
    private TextField Name;

    @FXML
    private PasswordField Password;

    @FXML
    private PasswordField  RePassword;

    @FXML
    private ChoiceBox<String> Role;

    @FXML
    private TextField UserName;

    public void backToLogin(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private String[] e={"Tenant","Owner"};
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Role.getItems().addAll(e);

    }
    public void signUp(ActionEvent e ) throws IOException {
        int flag = 0;
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();

            if (Name.getText().isEmpty() == true) {
                Name.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                Name.setStyle("-fx-border-color:black");
            }

            if (UserName.getText().isEmpty() == true) {
                UserName.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                UserName.setStyle("-fx-border-color:black");
            }
            if (Phone.getText().isEmpty() == true) {
                Phone.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                Phone.setStyle("-fx-border-color:black");
            }
            if (Email.getText().isEmpty() == true) {
                Email.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                Email.setStyle("-fx-border-color:black");
            }
            if (Password.getText().isEmpty() == true) {
                Password.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                Password.setStyle("-fx-border-color:black");
            }
            if (RePassword.getText().isEmpty() == true) {
                RePassword.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                RePassword.setStyle("-fx-border-color:black");
            }
            if (Age.getText().isEmpty() == true) {
                Age.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                Age.setStyle("-fx-border-color:black");
            }
            if (Role.getSelectionModel().isEmpty() == true) {
                Role.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                Role.setStyle("-fx-border-color:black");
            }
            int index = Email.getText().indexOf("@");
            System.out.println(index);
            if (index < 1) {
                Email.setStyle("-fx-border-color:red");
            } else {
                Email.setStyle("-fx-border-color:black");
            }

            if (Password.getText().equals(RePassword.getText()) == false ) {

                RePassword.setStyle("-fx-border-color:red");
                Password.setStyle("-fx-border-color:red");
                flag = 1;
            } else {
                if( Password.getText().isEmpty()==true && RePassword.getText().isEmpty()==true){
                    RePassword.setStyle("-fx-border-color:red");
                    Password.setStyle("-fx-border-color:red");
                }else{
                    RePassword.setStyle("-fx-border-color:black");
                    Password.setStyle("-fx-border-color:black");
                }

            }
            try {
                Integer.parseInt(Age.getText());

            } catch (Exception a) {
                Age.setStyle("-fx-border-color:red");
                flag = 1;
            }

            try {
                Integer.parseInt(Phone.getText());

            } catch (Exception a) {
                Phone.setStyle("-fx-border-color:red");
                flag = 1;
            }
            if (flag == 0) {


                Age.setStyle("-fx-border-color:black");
                String name[] = Name.getText().split(" ");
                String role = Role.getSelectionModel().getSelectedItem();

                String query = "insert into " + role + "(first_name,second_name,last_name,age,password,username,role,email,phonenumber) value ('" + name[0] + "'" + ",'" + name[1] + "','" + name[2] + "','" + Age.getText() + "','" + Password.getText() + "','" + UserName.getText() + "','" + Role.getSelectionModel().getSelectedItem() + "','" + Email.getText() + "','"+Phone.getText()+"')";
                System.out.println(query);
                statement.executeUpdate(query);
                Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();


            }






connection.close();
        }
        catch (Exception ex) {

            System.out.println("Failed to connect to the MySQL database!");
            ex.printStackTrace();
        }

    }
}
