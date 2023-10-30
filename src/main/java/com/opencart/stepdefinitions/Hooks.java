package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    @BeforeAll
    public static void theMethodExecutedBeforeAllTests(){
        System.out.println("The test execution started");
    }

    @Before
    public void beforeEachTest(){
        System.out.println("A new test execution started");
    }

    @After
    public void afterEachTest(){
        DriverManager.getInstance().tearDown();
        System.out.println("A test execution just finished");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("The test execution has been finished");
    }
}
