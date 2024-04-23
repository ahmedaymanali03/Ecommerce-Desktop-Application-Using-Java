package com.example.swttesting;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({EcommerceTest.class, OrdersTest.class, UserTest.class})
public class EcommerceOrdersUserSuite {
}
