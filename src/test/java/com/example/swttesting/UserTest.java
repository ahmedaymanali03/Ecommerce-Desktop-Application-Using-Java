package com.example.swttesting;

import org.junit.jupiter.api.*;

import static com.example.swttesting.orderController.getCurrentDateTimeAsString;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private ShoppingCart shoppingCart;
    private Orders order;
    private Product product;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        product = new Product("Test Product", 10.0, 5); // Assuming Product class has a constructor
        user = new User("John Doe", "john.doe@example.com", "password123");
    }

    @AfterEach
    void tearDown() {
        user = null;
        shoppingCart = null;
        product = null;
    }

    @Nested
    class ConstructorTests {

        @Test
        @DisplayName("User constructor")
        void testConstructor_ValidInput() {
            assertEquals("John Doe", user.getName(), "Name should be set correctly");
            assertEquals("john.doe@example.com", user.getEmail(), "Email should be set correctly");
            assertEquals("password123", user.getPassword(), "Password should be set correctly");
            assertNotNull(user.getShoppingCart(), "ShoppingCart should be initialized");
            assertTrue(user.getOrders().isEmpty(), "Orders list should be empty initially");
        }
    }

    @Nested
    class GetterAndSetterTests {

        @Test
        @DisplayName("User getters and setters")
        void testGettersAndSetters() {
            user.setName("Jane Doe");
            assertEquals("Jane Doe", user.getName(), "Name should be updated correctly");

            user.setEmail("jane.doe@example.com");
            assertEquals("jane.doe@example.com", user.getEmail(), "Email should be updated correctly");

            user.setPassword("newpassword");
            assertEquals("newpassword", user.getPassword(), "Password should be updated correctly");

            ShoppingCart newShoppingCart = new ShoppingCart();
            user.setShoppingCart(newShoppingCart);
            assertEquals(newShoppingCart, user.getShoppingCart(), "ShoppingCart should be updated correctly");
        }
    }

    @Nested
    class OrderAndCartTests {

        @Test
        @DisplayName("Add order")
        void testAddOrder() {
            Orders order = new Orders(getCurrentDateTimeAsString(), "confirmed", 1012.54, user.getShoppingCart());
            user.addOrder(order);
            assertEquals(1, user.getOrders().size(), "Order should be added to the list");
            assertEquals(order, user.getOrders().get(0), "Added order should be same as the one added");

            Orders order2 = new Orders(getCurrentDateTimeAsString(), "confirmed", 1012.54, user.getShoppingCart());
            user.addOrder(order2);
            assertEquals(2, user.getOrders().size(), "Another order should be added to the list");
            assertEquals(order2, user.getOrders().get(1), "Added order should be same as the one added");
        }

        @Test
        @DisplayName("Add product to cart")
        void testAddProductToCart() {
            user.addProductToCart(product, 2);
            assertEquals(1, user.getShoppingCart().getProducts().size(), "One product should be added in the cart");
            assertTrue(user.getShoppingCart().containsProduct(product, 2), "Product should be added to the cart with correct quantity");

            user.addProductToCart(product, 3);
            assertEquals(1, user.getShoppingCart().getProducts().size(), "only one of this product should be in the cart");
            assertTrue(user.getShoppingCart().containsProduct(product, 5), "Product quantity should be updated in the cart");
        }
    }
}
