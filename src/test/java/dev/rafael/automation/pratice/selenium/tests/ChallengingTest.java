package dev.rafael.automation.pratice.selenium.tests;

import dev.rafael.automation.pratice.selenium.pages.Challenging;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChallengingTest {

    private Challenging challenging;
    private final String URL = "https://the-internet.herokuapp.com/challenging_dom";

    @BeforeEach
    void setUp() throws Exception {
        this.challenging = new Challenging();
        this.challenging.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.challenging.quitWebDriver();
    }

    @Test
    void test() {
        //when
        this.challenging.viewBtnsOnPage();
        this.challenging.viewTableOnPage(this.challenging, this.URL);
        this.challenging.getCanvasDataUrl();

        //then
        Assertions.assertEquals("Challenging DOM", this.challenging.getTitlePage());
        Assertions.assertFalse(this.URL.equals(challenging.getCurrentUrl()));
    }
}
