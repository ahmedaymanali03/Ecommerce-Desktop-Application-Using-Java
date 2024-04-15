package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


import java.io.IOException;

import static com.example.swttesting.Ecommerce.products;


public class productCatalogueController {

    @FXML
    public Button cartButton;

    @FXML
    public Button logOutButton;
    @FXML
    private ListView<String> listView;

    private Stage stage;
    private Scene scene;
    private Parent root;



    private int cartCounter = Ecommerce.currentUser.getShoppingCart().getNoOfProducts();
    public void initialize() {

        cartButton.setText(cartCounter + " items in cart");
        for(int i = 0; i < products.size(); i++){
            listView.getItems().add(products.get(i).getName() + " - " + products.get(i).getPrice() + " - " + products.get(i).getQuantity());
        }
        Ecommerce.currentUser.addOrder(new Orders("1", "1", "1", 1, Ecommerce.currentUser.getShoppingCart()));

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected Item: " + newValue);
            cartCounter++;
            cartButton.setText(cartCounter + " items in cart");
            Ecommerce.currentUser.getShoppingCart().addProduct(products.get(listView.getSelectionModel().getSelectedIndex()), 1);
            //products.get(listView.getSelectionModel().getSelectedIndex()).setQuantity(products.get(listView.getSelectionModel().getSelectedIndex()).getQuantity() - 1);
            System.out.println(Ecommerce.currentUser.getShoppingCart().getTotal());

            listView.getItems().clear();
            for(int i = 0; i < products.size(); i++){

                listView.getItems().add(products.get(i).getName() + " - " + products.get(i).getPrice() + " - " + products.get(i).getQuantity());
            }


        });





    }

    public void switchToCart(ActionEvent event) throws IOException {
        System.out.println("Switching to cart");
        Parent root = FXMLLoader.load(getClass().getResource("shoppingCart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println(Ecommerce.currentUser.getShoppingCart().getTotal());
    }

    public void logOut(ActionEvent event) throws IOException {
        System.out.println("Logging out");
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Ecommerce.currentUser = null;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}