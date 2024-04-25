package com.example.swttesting;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Orders class tests")
class OrdersTest {


    private Orders order;
    private Orders order2;
    private ShoppingCart shoppingCart;
    private ShoppingCart shoppingCart2;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        order = new Orders("2024-04-23 10:00:00", "confirmed", 1012.54, shoppingCart,0);
        shoppingCart2 = new ShoppingCart();
        order2 = new Orders("2024-06-13 09:00:00", "confirmed", 1600.54, shoppingCart2);
    }

    @AfterEach
    void tearDown() {
        order = null;
        order2=null;
        shoppingCart2 = null;
        shoppingCart = null;
    }

    @Nested
    @Order(1)
    class ConstructorTests {

        @Test
        @DisplayName("Test Constructor with Valid Input")
        void testConstructor_ValidInput() {
            assertEquals(0, order.getOrderID(), "OrderID should be set correctly");
            assertEquals("2024-04-23 10:00:00", order.getOrderDate(), "OrderDate should be set correctly");
            assertEquals("confirmed", order.getOrderStatus(), "OrderStatus should be set correctly");
            assertEquals(1012.54, order.getOrderTotal(), "OrderTotal should be set correctly");
            assertEquals(shoppingCart, order.getShoppingCart(), "ShoppingCart should be set correctly");
        }
    }

    @Nested
    @Order(2)
    class GetterTests {

        @Test
        @DisplayName("Test Get OrderID")
        void testGetOrderID() {
            assertEquals(0, order.getOrderID(), "OrderID should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get OrderDate")
        void testGetOrderDate() {
            assertEquals("2024-04-23 10:00:00", order.getOrderDate(), "OrderDate should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get OrderStatus")
        void testGetOrderStatus() {
            assertEquals("confirmed", order.getOrderStatus(), "OrderStatus should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get OrderTotal")
        void testGetOrderTotal() {
            assertEquals(1012.54, order.getOrderTotal(), "OrderTotal should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get ShoppingCart")
        void testGetShoppingCart() {
            assertEquals(shoppingCart, order.getShoppingCart(), "ShoppingCart should be retrieved correctly");
        }
    }

    @Nested
    @Order(3)
    class GetterTests2 {

        @Test
        @DisplayName("Test Get OrderDate")
        void testGetOrderDate() {
            assertEquals("2024-06-13 09:00:00", order2.getOrderDate(), "OrderDate should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get OrderStatus")
        void testGetOrderStatus() {
            assertEquals("confirmed", order2.getOrderStatus(), "OrderStatus should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get OrderTotal")
        void testGetOrderTotal() {
            assertEquals(1600.54, order2.getOrderTotal(), "OrderTotal should be retrieved correctly");
        }

        @Test
        @DisplayName("Test Get ShoppingCart")
        void testGetShoppingCart() {
            assertEquals(shoppingCart2, order2.getShoppingCart(), "ShoppingCart should be retrieved correctly");
        }
    }


    @Nested
    @Order(4)
    class SetterTests {

        @Test
        @DisplayName("Test Set OrderID")
        void testSetOrderID() {
            order.setOrderID(1);
            assertEquals(1, order.getOrderID(), "OrderID should be updated correctly");
        }

        @Test
        @DisplayName("Test Set OrderDate")
        void testSetOrderDate() {
            order.setOrderDate("2024-04-24 10:00:00");
            assertEquals("2024-04-24 10:00:00", order.getOrderDate(), "OrderDate should be updated correctly");
        }

        @Test
        @DisplayName("Test Set OrderStatus")
        void testSetOrderStatus() {
            order.setOrderStatus("pending");
            assertEquals("pending", order.getOrderStatus(), "OrderStatus should be updated correctly");
        }

        @Test
        @DisplayName("Test Set OrderTotal")
        void testSetOrderTotal() {
            order.setOrderTotal(1020.55);
            assertEquals(1020.55, order.getOrderTotal(), "OrderTotal should be updated correctly");
        }

        @Test
        @DisplayName("Test Set ShoppingCart")
        void testSetShoppingCart() {
            ShoppingCart newShoppingCart = new ShoppingCart();
            order.setShoppingCart(newShoppingCart);
            assertEquals(newShoppingCart, order.getShoppingCart(), "ShoppingCart should be updated correctly");
        }
    }

    @Nested
    @Order(5)
    class CardVerificationTests {

        @Test
        @DisplayName("Test Verify Card with Valid Card")
        void testVerifyCard_ValidCard() {
            assertTrue(Orders.verifyCard("1234567890123456", "123", "08", "2024"), "Valid card should pass verification");
        }

        @Test
        @DisplayName("Test Verify Card with Invalid Card - Invalid Card Number Length")
        void testVerifyCard_InvalidCardNumberLength() {
            assertFalse(Orders.verifyCard("123456789012345", "123", "08", "2024"), "Card number length should be 16");
        }

        @Test
        @DisplayName("Test Verify Card with Invalid Card - Card Number Not Starting with '1234'")
        void testVerifyCard_CardNumberNotStartingWith1234() {
            assertFalse(Orders.verifyCard("9876543210123456", "123", "08", "2024"), "Card number should start with '1234'");
        }

        @Test
        @DisplayName("Test Verify Card with Invalid Card - Invalid CVV Length")
        void testVerifyCard_InvalidCVVLength() {
            assertFalse(Orders.verifyCard("1234567890123456", "1234", "08", "2024"), "CVV length should be 3");
        }

        @Test
        @DisplayName("Test Verify Card with Invalid Card - Non-Numeric Month")
        void testVerifyCard_NonNumericMonth() {
            assertFalse(Orders.verifyCard("1234567890123456", "123", "August", "2024"), "Month should be an integer");
        }

        @Test
        @DisplayName("Test Verify Card with Invalid Card - Non-Numeric Year")
        void testVerifyCard_NonNumericYear() {
            assertFalse(Orders.verifyCard("1234567890123456", "123", "08", "TwentyTwentyFour"), "Year should be an integer");
        }

        @Test
        @DisplayName("Test Verify Card with Invalid Card - Expired Card")
        void testVerifyCard_ExpiredCard() {
            assertFalse(Orders.verifyCard("1234567890123456", "123", "04", "2023"), "Year and month should not be before or equal to current year and month");
        }
    }

    @Nested
    @Order(6)
    class CurrentDateTimeTests {

        @Test
        @DisplayName("Test Get Current DateTime As String")
        void testGetCurrentDateTimeAsString() {
            String currentDateTime = Orders.getCurrentDateTimeAsString();
            assertNotNull(currentDateTime, "Current date and time should not be null");
            assertTrue(currentDateTime.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"), "Current date and time should be in the correct format");
        }
    }
}