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
import javafx.stage.Stage;


import java.io.IOException;

import static com.example.swttesting.Ecommerce.products;


public class shoppingCartController {

    @FXML
    private ListView<String> cartListView;

    @FXML
    private Button checkoutButton;

    @FXML
    public Label priceLabel;


    private Stage stage;
    private Scene scene;
    private Parent root;







    public void initialize() {
        //ObservableList<Product> observableList = FXCollections.observableArrayList(Ecommerce.currentUser.getShoppingCart().getProducts());
        System.out.println(Ecommerce.currentUser.getShoppingCart().getProducts());
        for(int i = 0; i < Ecommerce.currentUser.getShoppingCart().getProducts().size(); i++){
            cartListView.getItems().add(Ecommerce.currentUser.getShoppingCart().getProducts().get(i).getName());
        }

        priceLabel.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());
    }

    public void checkout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("checkout.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}