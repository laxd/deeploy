package uk.laxd.deepweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by lawrence on 04/05/16.
 */
public class ExecutorControllerSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void testStuff() throws Exception {
        driver.get("http://localhost:8090");
        WebElement webelement = driver.findElement(By.className("navbar-brand"));

        assertEquals("Deeploy", webelement.getText());
    }
}
