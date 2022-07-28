package functionaltest;

import base.BaseTest;
import factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

import static factory.DriverFactory.getDriver;


public class CartPageTest extends BaseTest {


    @Test
    private void testinfSomeCartRelatedTestHere() {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage
                .clickLoginBtn()
                .clickCartButton()
                .clickPayment();


    }




}
