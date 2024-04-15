package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


import javafx.scene.control.Label;


import java.io.IOException;

import static com.example.swttesting.Ecommerce.products;


public class shoppingCartController {

    @FXML
    private ListView<String> cartListView;

    @FXML
    private Button checkoutButton;

    // write code for the price label.
    @FXML
    private Label priceLabel;




    public void initialize() {
        //ObservableList<Product> observableList = FXCollections.observableArrayList(Ecommerce.currentUser.getShoppingCart().getProducts());
        System.out.println(Ecommerce.currentUser.getShoppingCart().getProducts());
        for(int i = 0; i < Ecommerce.currentUser.getShoppingCart().getProducts().size(); i++){
            cartListView.getItems().add(Ecommerce.currentUser.getShoppingCart().getProducts().get(i).getName());
        }
        priceLabel.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());
    }

}