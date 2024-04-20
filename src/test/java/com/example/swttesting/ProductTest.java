package com.example.swttesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Test Product", 10.0, 5);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }

    @Nested
    class ConstructorTests {

        @Test
        void testConstructor_ValidInput() {
            assertEquals("Test Product", product.getName(), "Name should be set correctly");
            assertEquals(10.0, product.getPrice(), "Price should be set correctly");
            assertEquals(5, product.getQuantity(), "Quantity should be set correctly");
        }
    }

    @Nested
    class GetterTests {

        @Test
        void testGetName() {
            assertEquals("Test Product", product.getName(), "Name should be retrieved correctly");
        }

        @Test
        void testGetPrice() {
            assertEquals(10.0, product.getPrice(), "Price should be retrieved correctly");
        }

        @Test
        void testGetQuantity() {
            assertEquals(5, product.getQuantity(), "Quantity should be retrieved correctly");
        }
    }

    @Nested
    class SetQuantityTests {

        @Test
        void testSetQuantity_PositiveQuantity() {
            product.setQuantity(10);
            assertEquals(10, product.getQuantity(), "Quantity should be updated correctly");
        }

        @Test
        void testSetQuantity_ZeroQuantity() {
            product.setQuantity(0);
            assertEquals(0, product.getQuantity(), "Quantity should be updated correctly");
        }

        @Test
        void testSetQuantity_NegativeQuantity() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> product.setQuantity(-1));
            assertEquals("Quantity cannot be negative", exception.getMessage(), "Exception message should be correct");
            assertEquals(5, product.getQuantity(), "Quantity should remain unchanged");
        }
    }
}