package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.YearMonth;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

public class orderController {


    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    private TextField cardNo;

    @FXML
    private TextField cvv;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    private Label total;

    public void initialize() {
        total.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());
    }


    public void switchToCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("shoppingCart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void completeOrder(ActionEvent event) throws IOException {
        if (Orders.verifyCard(cardNo.getText(), cvv.getText(), month.getText(), year.getText())) {

            Orders newOrder = new Orders(Orders.getCurrentDateTimeAsString(), "confirmed", Ecommerce.currentUser.getShoppingCart().getTotal(), Ecommerce.currentUser.getShoppingCart());
            Ecommerce.currentUser.addOrder(newOrder);
            System.out.println("Order completed successfully");
            for (int i = 0; i < Ecommerce.currentUser.getOrders().size(); i++) {
                System.out.println("Order ID: " + Ecommerce.currentUser.getOrders().get(i).getOrderID());
                System.out.println("Order Date: " + Ecommerce.currentUser.getOrders().get(i).getOrderDate());
                System.out.println("Order Status: " + Ecommerce.currentUser.getOrders().get(i).getOrderStatus());
                System.out.println("Order Total: " + Ecommerce.currentUser.getOrders().get(i).getOrderTotal());
                System.out.println("Shopping Cart: " + Ecommerce.currentUser.getOrders().get(i).getShoppingCart());
            }
            Ecommerce.currentUser.getShoppingCart().clear();
            Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            alert();
        }
    }
    public void alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Wrong input : please check the entered data");
        alert.showAndWait();
    }

}