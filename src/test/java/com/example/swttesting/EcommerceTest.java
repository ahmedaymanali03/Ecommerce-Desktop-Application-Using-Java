package com.example.swttesting;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EcommerceTest {

    @BeforeEach
    void setUp() {
        // Reset the state before each test
        Ecommerce.users.clear();
        Ecommerce.products.clear();
        Ecommerce.currentUser = null;
    }
    @AfterEach
    void tearDown() {
        // Reset the state after each test
        Ecommerce.users.clear();
        Ecommerce.products.clear();
        Ecommerce.currentUser = null;
    }
    @Nested
    class RegisterUserTests {
        @Test
        void testRegisterUser_ValidInput() {
            assertTrue(Ecommerce.registerUser("John Doe", "john.doe@email.com", "password123"), "User should be registered successfully");
            assertEquals(1, Ecommerce.users.size(), "User list should contain one user");
            assertEquals("John Doe", Ecommerce.currentUser.getName(), "Current user should be set correctly");
        }

        @Test
        void testRegisterUser_DuplicateEmail() {
            Ecommerce.registerUser("John Doe", "john.doe@email.com", "password123");
            assertFalse(Ecommerce.registerUser("John Doe", "john.doe@email.com", "password123"), "User should not be registered with duplicate email");
            assertEquals(1, Ecommerce.users.size(), "User list should still contain one user");
        }

        @Test
        void testAddProduct() {
            Ecommerce.addProduct("New Product", 100.0, 5);
            assertEquals(1, Ecommerce.products.size(), "Product list should contain one product");
            assertEquals("New Product", Ecommerce.products.get(0).getName(), "Product name should be set correctly");
        }

        @Test
        void testCheckUser_ValidCredentials() {
            Ecommerce.registerUser("John Doe", "john.doe@email.com", "password123");
            assertTrue(Ecommerce.checkuser("john.doe@email.com", "password123"), "User should be authenticated with correct credentials");
            assertEquals("John Doe", Ecommerce.currentUser.getName(), "Current user should be set correctly");
        }


    }

}
