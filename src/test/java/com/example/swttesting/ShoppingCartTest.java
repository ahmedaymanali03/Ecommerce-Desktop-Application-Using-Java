package com.example.swttesting;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product1;
    private Product product2;



    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Product 1", 10.0, 5);
        product2 = new Product("Product 2", 20.0, 3);
    }

    @AfterEach
    void tearDown() {
        cart = null;
        product1 = null;
        product2 = null;
    }

    @Nested
    class AddProductTests {

        @Test
        void testAddProduct_ValidInput() {
            cart.addProduct(product1, 2);
            assertEquals(2, cart.getNoOfProducts(product1), "Product quantity should be updated correctly");
        }

        @Test
        void testAddProduct_NegativeQuantity() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addProduct(product1, -1));
            assertEquals("Quantity must be greater than 0", exception.getMessage(), "Exception message should be correct");
        }

        @Test
        void testAddProduct_ZeroQuantity() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addProduct(product1, 0));
            assertEquals("Quantity must be greater than 0", exception.getMessage(), "Exception message should be correct");
        }

        @Test
        void testAddProduct_NotEnoughStock() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.addProduct(product1, 6));
            assertEquals("Not enough stock", exception.getMessage(), "Exception message should be correct");
        }
    }

    @Nested
    class RemoveProductTests {

        @Test
        void testRemoveProduct_ValidInput() {
            cart.addProduct(product1, 2);
            cart.removeProduct(product1, 1);
            assertEquals(1, cart.getNoOfProducts(product1), "Product quantity should be updated correctly");
        }

        @Test
        void testRemoveProduct_NegativeQuantity() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(product1, -1));
            assertEquals("Quantity must be greater than 0", exception.getMessage(), "Exception message should be correct");
        }

        @Test
        void testRemoveProduct_ZeroQuantity() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(product1, 0));
            assertEquals("Quantity must be greater than 0", exception.getMessage(), "Exception message should be correct");
        }

        @Test
        void testRemoveProduct_NotEnoughInCart() {
            cart.addProduct(product1, 2);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(product1, 6));
            assertEquals("Not enough stock", exception.getMessage(), "Exception message should be correct");
        }

    }

    @Nested
    class GettersTest{
        @Test
        void testGetTotal() {
            cart.addProduct(product1, 2);
            cart.addProduct(product2, 1);
            assertEquals(40, cart.getTotal(), "Total should be calculated correctly");
        }
        @Test
        void testGetProducts() {
            cart.addProduct(product1, 2);
            cart.addProduct(product2, 1);
            assertEquals(2, cart.getProducts().size(), "Products list should be retrieved correctly");
        }
    }
    @Nested
    class EmptyCartTest{
        @Test
        void testClear() {
            cart.addProduct(product1, 2);
            cart.addProduct(product2, 1);
            cart.clear();
            assertEquals(0, cart.getProducts().size(), "Products list should be empty");
        }
        @Test
        void testEmptyCart() {
            cart.addProduct(product1, 2);
            cart.addProduct(product2, 1);
            cart.clear();
            assertTrue(cart.isEmpty(), "Products list should be empty");
        }
    }
    @Nested
    class ContainsProductTests {

        @Test
        void testContainsProduct() {
            cart.addProduct(product1, 2);
            assertTrue(cart.containsProduct(product1), "Product should be in cart");
        }

        @Test
        void testContainsProductWithQuantity() {
            cart.addProduct(product1, 2);
            assertTrue(cart.containsProduct(product1, 2), "Product with specified quantity should be in cart");
        }

        @Test
        void testContainsProductWithWrongQuantity() {
            cart.addProduct(product1, 2);
            assertFalse(cart.containsProduct(product1, 3), "Product with wrong quantity should not be in cart");
        }

        @Test
        void testContainsProductWithMissingProduct() {
            assertFalse(cart.containsProduct(product2), "Product not added should not be in cart");
        }

        @Test
        void testContainsProductWithMissingProductAndQuantity() {
            assertFalse(cart.containsProduct(product2, 1), "Product not added should not be in cart");
        }
    }
}


