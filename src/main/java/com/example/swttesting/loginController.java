package com.example.swttesting;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loginController {
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToNextPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleLogin() throws IOException {
        String Email = usernameField.getText();
        String Password = passwordField.getText();

        if (Email.equals("admin") && Password.equals("admin")) {
            switchToNextPage(new ActionEvent());
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}