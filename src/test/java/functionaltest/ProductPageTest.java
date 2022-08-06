package functionaltest;

import base.BaseTestUI;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

import static factory.DriverFactory.getDriver;


public class ProductPageTest extends BaseTestUI {


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
