package dev.rafael.automation.pratice.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void test() {
        WebElement userElement = driver.findElement(By.id("username"));
        userElement.sendKeys("tomsmith");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        WebElement submitBtnElement = driver.findElement(By.xpath("submitBtnElement"));
        submitBtnElement.click();

        WebElement loggedMsg = driver.findElement(By.id("flash"));
        String textLogginAccount = loggedMsg.getText();

        Assertions.assertTrue(textLogginAccount.contains("You logged into a secure area!"));
    }

}
