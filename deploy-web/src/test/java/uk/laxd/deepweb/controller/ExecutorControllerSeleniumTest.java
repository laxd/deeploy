package uk.laxd.deepweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by lawrence on 04/05/16.
 */
public class ExecutorControllerSeleniumTest {

    private static final String URL = "http://localhost:8090";

    private WebDriver driver;

		private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
				wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testIndexPageLoads() throws Exception {
        driver.get(URL);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-brand")));
        WebElement webelement = driver.findElement(By.className("navbar-brand"));

        assertEquals("Deeploy", webelement.getText());
    }

    @Test
    public void testFlowsLinkNavigatesToFlowPage() throws Exception {
        driver.get(URL);
				driver.findElement(By.id("flows-link")).click();

				wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));

				assertTrue(driver.getCurrentUrl().endsWith("/flow"));
    }
}
