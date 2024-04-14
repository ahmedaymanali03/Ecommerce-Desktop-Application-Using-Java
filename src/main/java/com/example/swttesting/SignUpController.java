package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Ecommerce.registerUser(usernameField.getText(), emailField.getText(), passwordField.getText());
        Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
