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


public class pastOrdersController {

    @FXML
    private Button returnButton;
    @FXML
    private ListView<String> listView;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void initialize() {
        for(int i = 0; i < Ecommerce.currentUser.getOrders().size(); i++){
            listView.getItems().add(Ecommerce.currentUser.getOrders().get(i).getOrderID() + " - " + Ecommerce.currentUser.getOrders().get(i).getOrderTotal()+ " - " + Ecommerce.currentUser.getOrders().get(i).getOrderDate()+ " - " + Ecommerce.currentUser.getOrders().get(i).getOrderStatus());
        }
    }
    public void returnToCatalogue(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
