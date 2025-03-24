package dev.rafael.automation.pratice.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //Locators

    private By userElement = By.id("username");
    private By passwordElement = By.name("password");
    private By submitBtnLocator = By.xpath("//*[@id=\"login\"]/button");
    private By loggedMsg = By.id("flash");

    public void signin() {
        if (super.isDisplayed(userElement)) {
            super.type("tomsmith", userElement);
            super.type("SuperSecretPassword!", passwordElement);
            super.click(submitBtnLocator);
        } else {
            Assertions.fail("Failed to find the element 'username'");
        }
    }

    public String getMyAccountMessage() {
        return super.getText(loggedMsg);
    }

}
