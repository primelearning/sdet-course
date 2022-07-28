package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class ProductsPage {
    private static Logger LOG = LogManager.getLogger(ProductsPage.class);
    private WebDriver localDriver;

    //Step1: Implement JAVA coding standards to enable locators and usage of this class
    public ProductsPage(WebDriver driverObject) {
        this.localDriver = driverObject;
        PageFactory.initElements(localDriver,this);
        LOG.info("ProductsPage Elements initialized.");
    }

    //Step2: Identify all locators
    //Locators

    //Step3: Add user behavior methods
    public void addToCart() {
        //write code here
    }

    public CartPage clickCartButton() {
        //write code here
        return new CartPage(localDriver);
    }



}
