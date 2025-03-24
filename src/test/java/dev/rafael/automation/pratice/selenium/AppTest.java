package dev.rafael.automation.pratice.selenium;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AppTest {

    private WebDriver driverEdge;
    private WebDriver driverChrome;

    @Test
    public void helloSelenium() {
        try {
            //https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            EdgeOptions optionsEdge = new EdgeOptions();
            optionsEdge.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

            driverEdge = new EdgeDriver(optionsEdge);
            driverEdge.manage().window().maximize();
            driverEdge.get("https://www.bing.com/");

            WebElement elementInputTextEdge = driverEdge.findElement(By.id("sb_form_q"));
            elementInputTextEdge.sendKeys("Research test");
            elementInputTextEdge.submit();

            Thread.sleep(2000);
            driverEdge.quit();

            ChromeOptions optionsChrome = new ChromeOptions();
            optionsChrome.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

            driverChrome = new ChromeDriver(optionsChrome);
            driverChrome.manage().window().maximize();
            driverChrome.get("http://automationpractice.com/index.php");

            String currentUrl = driverChrome.getCurrentUrl();
            String expected = "http://automationpractice.com/index.php";

            Assertions.assertEquals(expected, currentUrl);

            Thread.sleep(2000);

            driverChrome.quit();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            driverEdge.quit();
            driverChrome.quit();
        }
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

}
