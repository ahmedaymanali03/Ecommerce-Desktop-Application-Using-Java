package com.example.swttesting;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
public class ShoppingCart {
  //  private Pair<Product, Integer> product;
    private HashMap<Product, Integer> products = new HashMap<Product, Integer>();

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product must be specified");
        }
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
            product.setQuantity(product.getQuantity() - quantity);
        } else {
            products.put(product, quantity);
            product.setQuantity(product.getQuantity() - quantity);
        }
    }

    public void removeProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product must be specified");
        }
        if (products.containsKey(product)) {
            if (products.get(product) < quantity) {
                throw new IllegalArgumentException("Not enough stock");
            }
            if(products.get(product) == quantity) {
                products.remove(product);
                product.setQuantity(product.getQuantity() + quantity);
                System.out.println(product.getQuantity() + " " + quantity);
            } else {
            products.put(product, products.get(product) - quantity);
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println(product.getQuantity() + " " + quantity);
            }
        } else {
            throw new IllegalArgumentException("Product not found in cart");
        }
    }

    public double getTotal() {
        double total = 0;
        for (Product product : products.keySet()) {
            total += product.getPrice() * products.get(product);
        }
        return total;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>(products.keySet());
    }

    public void clear() {
        products.clear();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public boolean containsProduct(Product product) {
        return products.containsKey(product);
    }


    public boolean containsProduct(Product product, int quantity) {
        return products.containsKey(product) && products.get(product) == quantity;
    }
//function that gets no of products in the shopping cart
    public int getNoOfProducts(){
        int noOfProducts = 0;
        for (Product product : products.keySet()) {
            noOfProducts += products.get(product);
        }
        return noOfProducts;
    }


    public int getNoOfProducts(Product product){
        return products.get(product);
    }
}
