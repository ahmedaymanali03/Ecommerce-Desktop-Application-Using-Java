package com.example.swttesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

    public void initialize()
    {
        total.setText("Total: " + Ecommerce.currentUser.getShoppingCart().getTotal());
    }


    public void switchToCart(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("shoppingCart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void completeOrder(ActionEvent event) throws IOException
    {
        if(verifyCard()) {

            Orders newOrder = new Orders(getCurrentDateTimeAsString(), "confirmed", Ecommerce.currentUser.getShoppingCart().getTotal(), Ecommerce.currentUser.getShoppingCart());
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
    }


    public boolean verifyCard() {
        if (!isLong(cardNo.getText()) || cardNo.getText().length() != 16) {
            System.out.println(1);
            return false;

        }
        if (!cardNo.getText().startsWith("1234")) {
            System.out.println(2);
            return false;
        }

        if(!isInteger(cvv.getText()) || cvv.getText().length() != 3){
            System.out.println(3);
            return false;
        }
        if(!isInteger(month.getText())){
            System.out.println(4);
            return false;
        }

        if (!isInteger(year.getText()))
        {
            System.out.println(5);
            return false;
        }

        if(isBeforeOrEqualCurrentYearAndMonth(Integer.parseInt(year.getText()), Integer.parseInt(month.getText()))){
            System.out.println(6);
            return false;
        }
        System.out.println(7);
        return true;
    }

    public boolean isLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isBeforeOrEqualCurrentYearAndMonth(int givenYear, int givenMonth) {
        YearMonth currentYearMonth = YearMonth.now();
        YearMonth givenYearMonth = YearMonth.of(givenYear, givenMonth);

        return givenYearMonth.isBefore(currentYearMonth) || givenYearMonth.equals(currentYearMonth);
    }




        // Function to get the current date and time as a formatted string
        public static String getCurrentDateTimeAsString()
        {
            // Get the current date and time
            LocalDateTime now = LocalDateTime.now();
            // Format the current date and time as a string
            return DATE_TIME_FORMATTER.format(now);
        }
}