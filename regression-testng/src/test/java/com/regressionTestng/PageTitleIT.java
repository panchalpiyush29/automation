package com.regressionTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PageTitleIT extends DriverBase {

    //Expected Result
    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    //Test Step
    private void googleExampleThatSearchesFor(final String searchString) {
        WebDriver driver = DriverBase.getDriver();

        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));

        searchField.clear();
        searchField.sendKeys(searchString);

        System.out.println("Page title is: " + driver.getTitle());

        searchField.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith(searchString));

        System.out.println("Page title is: " + driver.getTitle());
    }

    //Test Data
    @Test
    public void googleCheeseExample() {
        googleExampleThatSearchesFor("Cheese");
    }

    @Test
    public void googleAppleExample() {
        googleExampleThatSearchesFor("Apple");
    }

    @Test
    public void googleGoogleExample() {
        googleExampleThatSearchesFor("Google");
    }

    @Test
    public void googleCricketExample() {
        googleExampleThatSearchesFor("Cricket");
    }
}
