package apitests;

import apimethods.Booking;
import base.BaseTestApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.createbooking.BookingDates;
import pojo.createbooking.CreateBookingParent;


public final class UpdateBookingTest extends BaseTestApi {


    @Test
    public void verifyIfBookingDetailsCanBeUpdated(){
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

        BookingDates bookingdates_updated = BookingDates.builder()
                .checkin("2022-08-01")
                .checkout("2022-08-03")
                .build();
        CreateBookingParent updateBookingRequest = CreateBookingParent.builder()
                .firstname("Avishek_updated")
                .lastname("Behera")
                .additionalneeds("Breakfast")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingdates_updated)
                .build();

        //Act
        Response responseUpdatedBooking = Booking.updateBookingDetails(bookingId,updateBookingRequest);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(responseUpdatedBooking.statusCode(),200);
        softAssert.assertEquals(responseUpdatedBooking.getBody().jsonPath().get("firstname"),"Avishek_updated");
        softAssert.assertEquals(responseUpdatedBooking.getBody().jsonPath().get("bookingdates.checkin"),"2022-08-01");
        softAssert.assertAll();

    }


}
