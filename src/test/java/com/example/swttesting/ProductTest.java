package com.example.swttesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    /**
     * Set up the Product object before each test
     */
    @BeforeEach
    void setUp() {

        product = new Product("Laptop", 1000.99, 10);
    }

    /**
     * Tear down the Product object after each test
     */
    @AfterEach
    void tearDown() {

        product = null;
    }

    /**
     * Test the getName method of the Product class
     */
    @Test
    @Order(1)
    void getNameTest() {

        assertEquals("Laptop", product.getName());
    }

    /**
     * Test the getPrice method of the Product class
     */
    @Test
    @Order(2)
    void getPriceTest() {

        assertEquals(1000.99, product.getPrice());
    }

    /**
     * Test the getQuantity method of the Product class
     */
    @Test
    @Order(3)
    void getQuantityTest() {
    }

    /**
     * Test the setQuantity method of the Product class
     */
    @Test
    @Order(4)
    void setQuantityTest() {
        product.setQuantity(20);
        // Check if the quantity is set to 20
        assertEquals(20, product.getQuantity());
        // Check if we can make quantity negative
        product.setQuantity(-10);
        // Check if the quantity remains 20
        assertEquals(0, product.getQuantity());

    }
}