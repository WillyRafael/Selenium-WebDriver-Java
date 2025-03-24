package dev.rafael.automation.pratice.selenium.tests;

import dev.rafael.automation.pratice.selenium.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginPageTest {

    private LoginPage loginPage;
    private final String URL = "https://the-internet.herokuapp.com/login";

    @BeforeEach
    void setUp() throws Exception {
        this.loginPage = new LoginPage();
        this.loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.loginPage.quitWebDriver();
    }

    @Test
    void test() {
        //when
        this.loginPage.signin();

        //then
        Assertions.assertTrue(this.loginPage.getMyAccountMessage().contains("You logged into a secure area!"));
        Assertions.assertFalse(!this.loginPage.getMyAccountMessage().contains("You logged into a secure area!"));
    }

}
