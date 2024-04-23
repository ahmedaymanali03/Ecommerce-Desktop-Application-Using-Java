package com.example.swttesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product class tests")
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
    @Order(1)
    class ConstructorTests {

        @Test
        @DisplayName("Test Constructor with Valid Input")
        void testConstructor_ValidInput() {
            assertEquals("Test Product", product.getName(), "Name should be set correctly");
            assertEquals(10.0, product.getPrice(), "Price should be set correctly");
            assertEquals(5, product.getQuantity(), "Quantity should be set correctly");
        }
    }

    @Nested
    @Order(2)
    class GetterTests {

        @Test
        @DisplayName("Test Get Name")
        void testGetName() {
            assertEquals("Test Product", product.getName(), "Name should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get Price")
        void testGetPrice() {
            assertEquals(10.0, product.getPrice(), "Price should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get Quantity")
        void testGetQuantity() {
            assertEquals(5, product.getQuantity(), "Quantity should be retrieved correctly");
        }
    }

    @Nested
    @Order(3)
    class SetQuantityTests {

        @Test
        @DisplayName("Test Set Quantity with Positive Quantity")
        void testSetQuantity_PositiveQuantity() {
            product.setQuantity(10);
            assertEquals(10, product.getQuantity(), "Quantity should be updated correctly");
        }

        @Test
        @DisplayName("Test Set Quantity with Zero Quantity")
        void testSetQuantity_ZeroQuantity() {
            product.setQuantity(0);
            assertEquals(0, product.getQuantity(), "Quantity should be updated correctly");
        }

        @Test
        @DisplayName("Test Set Quantity with Negative Quantity")
        void testSetQuantity_NegativeQuantity() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> product.setQuantity(-1));
            assertEquals("Quantity cannot be negative", exception.getMessage(), "Exception message should be correct");
            assertEquals(5, product.getQuantity(), "Quantity should remain unchanged");
        }
    }
}