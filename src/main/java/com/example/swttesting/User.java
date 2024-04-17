package com.example.swttesting;

import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private String password;

    private ShoppingCart shoppingCart;

    private ArrayList<Orders> orders = new ArrayList<Orders>();
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.shoppingCart = new ShoppingCart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addOrder(Orders order) {
        orders.add(order);
    }

    public void addProductToCart(Product product, int quantity) {
        shoppingCart.addProduct(product, quantity);
    }

}
