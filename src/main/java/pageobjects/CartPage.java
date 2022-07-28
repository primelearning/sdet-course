package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class CartPage {
    private static Logger LOG = LogManager.getLogger(CartPage.class);
    private WebDriver localDriver;

    //Step1: Implement JAVA coding standards to enable locators and usage of this class
    public CartPage(WebDriver driverObject) {
        this.localDriver = driverObject;
        PageFactory.initElements(localDriver,this);
        LOG.info("CartPage Elements initialized.");
    }

    //Step2: Identify all locators
    //Locators

    //Step3: Add user behavior methods
    public void clickPayment() {
        //write code here
        // Return Payment page object here as part of page chaining
    }



}
