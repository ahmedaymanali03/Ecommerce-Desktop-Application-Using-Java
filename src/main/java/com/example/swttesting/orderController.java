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
import java.time.LocalDate;
import java.time.YearMonth;

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
            Parent root = FXMLLoader.load(getClass().getResource("productCatalogue.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    public boolean verifyCard() {
        if (!isInteger(cardNo.getText()) || cardNo.getText().length() != 16) {
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

        if(!isBeforeOrEqualCurrentYearAndMonth(Integer.parseInt(month.getText()), Integer.parseInt(year.getText()))){
            System.out.println(6);
            return false;
        }
        System.out.println(7);
        return true;
    }

    public boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
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

}
