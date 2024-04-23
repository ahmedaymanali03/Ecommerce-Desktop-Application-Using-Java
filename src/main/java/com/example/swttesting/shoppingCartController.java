package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

import static com.example.swttesting.Ecommerce.products;


public class shoppingCartController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button checkoutButton;
    @FXML
    private Button returnButton;

    @FXML
    public Label priceLabel;


    private Stage stage;
    private Scene scene;
    private Parent root;







    public void initialize() {
        int cartCounter = Ecommerce.currentUser.getShoppingCart().getNoOfProducts();

        //ObservableList<Product> observableList = FXCollections.observableArrayList(Ecommerce.currentUser.getShoppingCart().getProducts());
        System.out.println(Ecommerce.currentUser.getShoppingCart().getProducts());
        for(int i = 0; i < Ecommerce.currentUser.getShoppingCart().getProducts().size(); i++){
           listView.getItems().add(Ecommerce.currentUser.getShoppingCart().getProducts().get(i).getName()+ " - " + Ecommerce.currentUser.getShoppingCart().getProducts().get(i).getPrice() + " - " + Ecommerce.currentUser.getShoppingCart().getNoOfProducts(Ecommerce.currentUser.getShoppingCart().getProducts().get(i)));
        }
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected Item: " + newValue);

            Ecommerce.currentUser.getShoppingCart().removeProduct(Ecommerce.currentUser.getShoppingCart().getProducts().get(listView.getSelectionModel().getSelectedIndex()), 1);
            //Ecommerce.currentUser.getShoppingCart().getProducts().get(listView.getSelectionModel().getSelectedIndex()).setQuantity(products.get(listView.getSelectionModel().getSelectedIndex()).getQuantity() + 1);
            System.out.println(Ecommerce.currentUser.getShoppingCart().getTotal());
            priceLabel.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());

            listView.getItems().clear();
            for(int i = 0; i < products.size(); i++){

                listView.getItems().add(Ecommerce.currentUser.getShoppingCart().getProducts().get(i).getName()+ " - " + Ecommerce.currentUser.getShoppingCart().getProducts().get(i).getPrice() + " - " + Ecommerce.currentUser.getShoppingCart().getNoOfProducts(Ecommerce.currentUser.getShoppingCart().getProducts().get(i)));

          //  priceLabel.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());
                }
        });
        priceLabel.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());
    }

    public void checkout(ActionEvent event) throws IOException {
        if (Ecommerce.currentUser.getShoppingCart().getNoOfProducts() != 0) {


        Parent root = FXMLLoader.load(getClass().getResource("order.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        }
        else {
            alert();
        }
    }

    public void returnToCatalogue(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    public void alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Cart is empty!");
        alert.showAndWait();
    }
}