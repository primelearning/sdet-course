package FunctionalTest;

import Base.BaseTest;
import static Factory.DriverFactory.*;

import PageObjects.SouthWestPage;
import Utilities.LoadConfig;
import org.testng.annotations.Test;

public class SouthWestTest extends BaseTest {

    @Test
    public void searchFlights(){

        String departMonth=LoadConfig.SOUTH_WEST.getProperty("DEPART_MONTH");
        String departDay=LoadConfig.SOUTH_WEST.getProperty("DEPART_DAY");
        String returnMonth=LoadConfig.SOUTH_WEST.getProperty("RETURN_MONTH");
        String returnDay=LoadConfig.SOUTH_WEST.getProperty("RETURN_DAY");
        String departLocation=LoadConfig.SOUTH_WEST.getProperty("DEPART_LOCATION");
        String returnLocation=LoadConfig.SOUTH_WEST.getProperty("RETURN_LOCATION");
        getDriver().get(LoadConfig.SOUTH_WEST.getProperty("AIRLINE-URL"));
        SouthWestPage southWestPage=new SouthWestPage(getDriver());
        getDriver().manage().window().maximize();
        southWestPage.enterDepartLocation(departLocation);
        southWestPage.enterArriveLocation(returnLocation);

        southWestPage.clickDepartDate();
        southWestPage.setDate(departMonth,departDay);
        southWestPage.clickReturnDate();
        southWestPage.setDate(returnMonth,returnDay);
        southWestPage.searchFlights();


    }
}
