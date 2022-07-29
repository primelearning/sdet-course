package PageObjects;

import Utilities.LoadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouthWestPage {
    WebDriver driver;
    String monthYear;
    public SouthWestPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css="#LandingAirBookingSearchForm_originationAirportCode") WebElement depart;
    @FindBy(css = "#LandingAirBookingSearchForm_destinationAirportCode") WebElement arrive;

    @FindBy(css = "#LandingAirBookingSearchForm_departureDate") WebElement departDate;
    @FindBy(css = "#LandingAirBookingSearchForm_returnDate") WebElement returnDate;
    @FindBy(css = "button[aria-label='Previous Month']") WebElement previousMonth;
    @FindBy(css="button[aria-label='Next Month']") WebElement nextMonth;
    @FindBy(css=".calendar-month--title") WebElement departMonthYear;
    @FindBy(css="#LandingAirBookingSearchForm_submit-button") WebElement search;

    public void enterDepartLocation(String departLocation){

        depart.click();
        depart.sendKeys(departLocation);
    }

    public void enterArriveLocation(String returnLocation){
        arrive.sendKeys(returnLocation);
    }

    public void clickDepartDate(){
        departDate.click();
    }


    public void setDate(String month,String depart_day){


        while (!departMonthYear.getText().contains(month)) {
            nextMonth.click();
        }

           driver.findElement(By.xpath("//button/span[contains(text(),'"+depart_day+"')]/parent::button")).click();

    }

    public void clickReturnDate(){
        returnDate.click();
    }

    public void searchFlights(){

       search.click();
    }


}
