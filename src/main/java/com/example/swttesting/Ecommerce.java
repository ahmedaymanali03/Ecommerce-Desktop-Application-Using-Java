package com.example.swttesting;

import java.util.ArrayList;

public class Ecommerce {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Product> products = new ArrayList<Product>();

    public void registerUser(String name, String email, String password) {
        users.add(new User(name, email, password));
    }

    public void addProduct(String name, double price, int quantity) {
        products.add(new Product(name, price, quantity));
    }

   public Ecommerce(){

        addProduct("Laptop", 1000, 10);
        addProduct("Mouse", 20, 100);
        addProduct("Keyboard", 50, 50);
        addProduct("Monitor", 200, 20);
        addProduct("Headphones", 100, 30);
        addProduct("Speakers", 150, 40);
        addProduct("Microphone", 80, 60);
        addProduct("Webcam", 70, 70);
        addProduct("Printer", 300, 10);
        addProduct("Scanner", 200, 20);
        addProduct("Projector", 500, 5);
        addProduct("Tablet", 400, 15);
        addProduct("Smartphone", 600, 25);
        addProduct("Smartwatch", 300, 30);
        addProduct("Fitness Tracker", 100, 50);
        addProduct("Gaming Console", 400, 10);
        addProduct("Gaming Controller", 50, 100);
        addProduct("Gaming Headset", 100, 50);
        addProduct("Gaming Keyboard", 80, 60);
        addProduct("Gaming Mouse", 70, 70);
        addProduct("Gaming Monitor", 200, 20);
        addProduct("Gaming Laptop", 1000, 10);
        addProduct("Gaming PC", 1500, 5);
        addProduct("Gaming Chair", 200, 20);
       registerUser("Ahmed Ali", "ahmed.ali@email.com", "securePass123");
       registerUser("Fatima Mahmoud", "fatima.mahmoud@email.com", "fatima1234");
       registerUser("Youssef Ibrahim", "youssef.ibrahim@email.com", "youssef2024");
       registerUser("Nour Khalil", "nour.khalil@email.com", "nourPass!@#");
       registerUser("Mohamed Hassan", "mohamed.hassan@email.com", "moh1234");
       registerUser("Aya Samir", "aya.samir@email.com", "ayaPass2024");
       registerUser("Omar Abdelrahman", "omar.abdelrahman@email.com", "omarSecure!");
       registerUser("Sara Ahmed", "sara.ahmed@email.com", "saraPassword");
    }

}
