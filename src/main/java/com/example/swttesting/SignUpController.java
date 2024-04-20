package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    public void switchToProductCatalogue(ActionEvent event) throws IOException
    {
        boolean registered;
        registered = Ecommerce.registerUser(usernameField.getText(), emailField.getText(), passwordField.getText());
        if (!registered)
        {
            alert();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("User " + Ecommerce.currentUser.getName()+ " has been registered successfully");
    }

    public void switchToLogin(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Wrong input : please check the entered data");
        alert.showAndWait();
    }
}
