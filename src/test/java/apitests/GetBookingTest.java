package apitests;

import apimethods.Booking;
import base.BaseTestApi;
import io.restassured.response.Response;
import org.bson.Document;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.createbooking.BookingDates;
import pojo.createbooking.CreateBookingParent;
import utilities.JsonUtil;

import java.util.HashMap;


public final class GetBookingTest extends BaseTestApi {


    @Test
    public void verifyIfGetByIdIsreturningCorrectBookingDetails(){
        //Arrange
        BookingDates bookingdates = BookingDates.builder()
                .checkin("2022-08-01")
                .checkout("2022-08-03")
                .build();
        CreateBookingParent createBookingParent = CreateBookingParent.builder()
                .firstname("Avishek")
                .lastname("Behera")
                .additionalneeds("Breakfast")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingdates)
                .build();

        Response responseCreateBooking = Booking.createBooking(createBookingParent);
        int bookingId = Booking.getBookingId(responseCreateBooking);

        //Act
        Response responseGetById = Booking.getBookigDetailsByID(bookingId);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(responseGetById.statusCode(),200);
        softAssert.assertEquals(responseGetById.getBody().jsonPath().get("firstname"),"Avishek");
        softAssert.assertEquals(responseGetById.getBody().jsonPath().get("bookingdates.checkin"),"2022-08-01");
        softAssert.assertAll();

    }


}
