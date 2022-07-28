package functionaltest;

import base.BaseTest;
import factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

import static factory.DriverFactory.getDriver;


public class ProductPageTest extends BaseTest {


    @Test
    private void testingSomeProductPageRelatedTest() {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        ProductsPage productsPage=loginPage.clickLoginBtn();
        productsPage.addToCart();

        loginPage
                .clickLoginBtn()
                .addToCart();


    }



}
