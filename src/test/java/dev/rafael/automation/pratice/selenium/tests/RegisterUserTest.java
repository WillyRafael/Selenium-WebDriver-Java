package dev.rafael.automation.pratice.selenium.tests;

import dev.rafael.automation.pratice.selenium.pages.RegisterUser;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class RegisterUserTest {

    private RegisterUser registerUser;
    private final String URL = "https://www.automationexercise.com";
    private final String PATH_LOGIN = "/login";
    private final String PATH_SIGNUP = "/signup";

    @BeforeEach
    void setUp() throws Exception {
        this.registerUser = new RegisterUser();
        this.registerUser.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.registerUser.quitWebDriver();
    }

    @Test
    public void test() {
        testSignUp();
        testLogin();
    }

    private void testLogin() {
        registerUser.visit(URL + PATH_LOGIN);
        registerUser.login("rafawilly123@gmail.com", "password123");
    }

    private void testSignUp() {
        HashMap<By, String> data = new HashMap<>();

        data.put(registerUser.getTitleMr(), "Y");
        data.put(registerUser.getTitleMrs(), "N");
        data.put(registerUser.getPassword(), "password123");
        data.put(registerUser.getDays(), "1");
        data.put(registerUser.getMonths(), "1");
        data.put(registerUser.getYears(), "1990");
        data.put(registerUser.getNewsletter(), "Y");
        data.put(registerUser.getOptin(), "Y");
        data.put(registerUser.getFirstName(), "Willy");
        data.put(registerUser.getLastName(), "Rafael");
        data.put(registerUser.getCompany(), "Company");
        data.put(registerUser.getAddress1(), "Address 1");
        data.put(registerUser.getAddress2(), "Address 2");
        data.put(registerUser.getCountry(), "United States");
        data.put(registerUser.getState(), "State");
        data.put(registerUser.getZipcode(), "12345");
        data.put(registerUser.getCity(), "City");
        data.put(registerUser.getMobileNumber(), "1234567890");

        registerUser.visit(URL + PATH_SIGNUP);
        registerUser.signUp("rafael", "rafawilly123@gmail.com", data);

    }

    private void testDeleteUser() {
        registerUser.visit(URL);
        registerUser.deleteUser();
    }

    private void testLogoutUser() {
        registerUser.visit(URL);
        registerUser.logoutUser();
    }

}
