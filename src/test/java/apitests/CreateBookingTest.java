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


public final class CreateBookingTest extends BaseTestApi {

    @Test
    public void verifyIfNewBookingCanBeCreated_usingString(){
        String requestBody = "{\n" +
                "    \"firstname\": \"Avishek\",\n" +
                "    \"lastname\": \"Behera\",\n" +
                "    \"totalprice\": 222,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        Response response = Booking.createBooking(requestBody);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Avishek");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2018-01-01");
        softAssert.assertAll();
    }

    @Test
    public void verifyIfNewBookingCanBeCreated_usingHashMap(){
        HashMap<String,Object> bookingDates = new HashMap<>();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        HashMap<String,Object> parentRequestBody = new HashMap<>();
        parentRequestBody.put("firstname","Avishek");
        parentRequestBody.put("lastname","Behera");
        parentRequestBody.put("totalprice",333);
        parentRequestBody.put("depositpaid",true);
        parentRequestBody.put("additionalneeds","Breakfast");

        parentRequestBody.put("bookingdates",bookingDates);


        Response response = Booking.createBooking(parentRequestBody);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Avishek");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2018-01-01");
        softAssert.assertAll();
    }

    @Test
    public void verifyIfNewBookingCanBeCreated_usingPojo(){
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


        Response response = Booking.createBooking(createBookingParent);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertNotNull(response.getBody().jsonPath().get("bookingid"));
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Avishek");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2022-08-01");
        softAssert.assertAll();

    }

    @Test
    public void verifyIfNewBookingCanBeCreated_usingJsonFile(){
        Document createBookingParent =
                JsonUtil.updateValue("src/test/resources/booking/createBookingRequest.json","{{checkin}}","2022-09-01");
        Document createBookingParent_updated = JsonUtil.updateValue(createBookingParent,"{{checkout}}","2022-09-05");

        Response response = Booking.createBooking(createBookingParent_updated);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertNotNull(response.getBody().jsonPath().get("bookingid"));
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Avishek");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2022-08-01");
        softAssert.assertAll();

    }

    @Test
    public void verifyIfNewBookingCanBeCreatedWithoutBreakfast(){
        BookingDates bookingdates = BookingDates.builder()
                .checkin("2022-08-01")
                .checkout("2022-08-03")
                .build();
        CreateBookingParent createBookingParent = CreateBookingParent.builder()
                .firstname("Avishek")
                .lastname("Behera")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingdates)
                .build();


        Response response = Booking.createBooking(createBookingParent);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertNotNull(response.getBody().jsonPath().get("bookingid"));
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Avishek");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2022-08-01");
        softAssert.assertAll();

    }

    @Test
    public void verifyIfNewBookingCanBeCreatedWithDepositpaidAsFalse(){
        BookingDates bookingdates = BookingDates.builder()
                .checkin("2022-08-01")
                .checkout("2022-08-03")
                .build();
        CreateBookingParent createBookingParent = CreateBookingParent.builder()
                .firstname("Avishek")
                .lastname("Behera")
                .totalprice(111)
                .depositpaid(false)
                .bookingdates(bookingdates)
                .build();


        Response response = Booking.createBooking(createBookingParent);

        //Assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertNotNull(response.getBody().jsonPath().get("bookingid"));
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Avishek");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2022-08-01");
        softAssert.assertFalse(response.getBody().jsonPath().get("booking.depositpaid"));
        softAssert.assertAll();

    }

}
