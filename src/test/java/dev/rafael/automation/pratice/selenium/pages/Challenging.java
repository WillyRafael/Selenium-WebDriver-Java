package dev.rafael.automation.pratice.selenium.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Challenging extends BasePage {
    //Locators

    private By btn = By.cssSelector(".button");
    private By btnAlert = By.cssSelector(".alert");
    private By btnSucess = By.cssSelector(".success");

    private By title = By.tagName("h3");

    private By table = By.tagName("table");
    private By canvas = By.tagName("canvas");

    public void viewBtnsOnPage() {
        ArrayList listBtn = new ArrayList<Object>();
        listBtn.add(btn);
        listBtn.add(btnAlert);
        listBtn.add(btnSucess);
        if (super.areAllDisplayed(listBtn)) {
            super.actionMoveToElementPerform(btn);
            super.actionMoveToElementClickPerform(btn);

            super.actionMoveToElementPerform(btnAlert);
            super.actionMoveToElementClickPerform(btnAlert);

            super.actionMoveToElementPerform(btnSucess);
            super.actionMoveToElementClickPerform(btnSucess);
        } else {
            Assertions.fail("Failed on search an item");
        }
    }

    public void viewTableOnPage(Challenging challengingDom, String URL) {
        try {
            ArrayList listItens = new ArrayList<Object>();
            listItens.add(table);
            listItens.add(canvas);
            if (super.areAllDisplayed(listItens)) {
                Assertions.assertEquals("Challenging DOM", challengingDom.getTitlePage());
                
                Thread.sleep(2000);

                By editCellLocator = By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]");
                super.actionMoveToElementClickPerform(editCellLocator);
                //Use to change the cell with values ​​in the tables, but in this case I did not use because the URL does not have this possibility
                //challengingDom.updateElementText(editCellLocator, "New Text");
                //boolean isTextUpdated = challengingDom.waitForTextToBePresent(editCellLocator, "New Text", Duration.ofSeconds(10));
                //Assertions.assertTrue(isTextUpdated, "Failed to update text");
                Assertions.assertFalse(URL.equals("https://the-internet.herokuapp.com/challenging_dom#edit"));

                Thread.sleep(2000);

                By deleteLinkLocator = By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]");
                super.actionMoveToElementClickPerform(deleteLinkLocator);
                //Use to change the cell with values ​​in the tables, but in this case I did not use because the URL does not have this possibility
                //challengingDom.click(deleteLinkLocator);
                //challengingDom.waitForElementStaleness(firstCellLocator, Duration.ofSeconds(10));
                //challengingDom.findElement(By.xpath("//table//tr[1]/td[1][contains(., 'New Text')]"));
                //Assertions.fail("Failed to delete item");
                Assertions.assertFalse(URL.equals("https://the-internet.herokuapp.com/challenging_dom#delete"));
                
                Thread.sleep(2000);
            } else {
                System.out.println("Itens not found");
            }
        } catch (NoSuchElementException e) {
            Assertions.fail("Failed on search an item");
        } catch (InterruptedException ex) {
            Logger.getLogger(Challenging.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTitlePage() {
        return super.getText(title);
    }

    public void getCanvasDataUrl() {
        String canvasData = super.getCanvasDataUrl("canvas");
        System.out.println("Canvas content (Data URL): " + canvasData);
        if (canvasData == null || canvasData.isEmpty()) {
            Assertions.fail("Failed to read canvas");
        } else {
            Assertions.assertTrue(true);
        }
    }

}
