package com.example.swttesting;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EcommerceTest {

    @BeforeEach
    void setUp() {
        // Set up the state before each test
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
        void testAddProduct_DuplicateName() {
            Ecommerce.addProduct("New Product", 100.0, 5);
            Ecommerce.addProduct("New Product", 100.0, 5);
            assertEquals(1, Ecommerce.products.size(), "Product list should contain one product");
        }

        @Test
        void testCheckUser_ValidCredentials() {
            Ecommerce.registerUser("John Doe", "john.doe@email.com", "password123");
            assertTrue(Ecommerce.checkuser("john.doe@email.com", "password123"), "User should be authenticated with correct credentials");
            assertEquals("John Doe", Ecommerce.currentUser.getName(), "Current user should be set correctly");
        }


    }
    @Nested
    class LoginandLogoutTests {
        @Test
        void testCheckUser_ValidCredentials() {
            Ecommerce.registerUser("Ahmed Ali", "ahmed.ali@email.com", "securePass123");
            Ecommerce.logout();
            Ecommerce.checkuser("ahmed.ali@email.com", "securePass123");
            assertTrue(Ecommerce.currentUser.getName().equals("Ahmed Ali"), "User should be authenticated with correct credentials");
         }
        @Test
        void testCheckUser_InvalidCredentials() {
            Ecommerce.registerUser("Ahmed Ali", "ahmed.ali@emai.com", "securePass123");
            Ecommerce.logout();
            Ecommerce.checkuser("ahmed", "password");
            assertNull(Ecommerce.currentUser, "User should not be authenticated with incorrect credentials");
        }
        @Test
        void testLogout() {
            Ecommerce.registerUser("Ahmed Ali", "ahmed.ali@emai.com", "securePass123");
            Ecommerce.logout();
            assertNull(Ecommerce.currentUser, "User should be logged out");

    }

    }


}
