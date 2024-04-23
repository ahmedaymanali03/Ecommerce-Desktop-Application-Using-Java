package com.example.swttesting;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Orders {
    private static int instanceCounter = 0;

    private int orderID;
    private String orderDate;
    private String orderStatus;
    private double orderTotal;
    private ShoppingCart shoppingCart;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Orders(String orderDate, String orderStatus, double orderTotal, ShoppingCart shoppingCart) {
        this.orderID = instanceCounter++;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.shoppingCart = shoppingCart;

    }

    public Orders(String orderDate, String orderStatus, double orderTotal, ShoppingCart shoppingCart,int orderID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.shoppingCart = shoppingCart;

    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public static boolean verifyCard(String cardNo, String cvv, String month, String year)
    {
        if (!isLong(cardNo) || cardNo.length() != 16) {
            System.out.println(1);
            return false;

        }
        if (!cardNo.startsWith("1234")) {
            System.out.println(2);
            return false;
        }

        if(!isInteger(cvv) || cvv.length() != 3){
            System.out.println(3);
            return false;
        }
        if(!isInteger(month)){
            System.out.println(4);
            return false;
        }

        if (!isInteger(year))
        {
            System.out.println(5);
            return false;
        }

        if(isBeforeOrEqualCurrentYearAndMonth(Integer.parseInt(year), Integer.parseInt(month))){
            System.out.println(6);
            return false;
        }
        System.out.println(7);
        return true;
    }

    public static boolean isLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBeforeOrEqualCurrentYearAndMonth(int givenYear, int givenMonth) {
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