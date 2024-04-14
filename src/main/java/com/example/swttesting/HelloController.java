package com.example.swttesting;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public static class shoppingCartController {
    }

    public static class productCatalogueController {
    }

    public static class signUpController {
    }
}