package functionaltest;

import base.BaseTestUI;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static factory.DriverFactory.getDriver;


public class CartPageTest extends BaseTestUI {


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
