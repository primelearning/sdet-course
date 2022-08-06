package apimethods;

import apiutils.BaseSpec;
import static configurations.ConfigManager.*;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public final class Booking {

    private Booking(){
    }
    private static final String BASE_URI_BOOKING  = ENV_PROPERTIES.getProperty("BASE_URL_API");

    public static Response createBooking(Object requestBody) {

        return given(BaseSpec.getBasicRequestSpec(BASE_URI_BOOKING))
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .spec(BaseSpec.getBasicResponseSpec())
                .log()
                .ifError()
                .extract()
                .response();
    }

    public static int getBookingId(Response response) {
        return response.body().jsonPath().get("bookingid");
    }

    public static Response getBookigDetailsByID(int id) {
        return given(BaseSpec.getBasicRequestSpec(BASE_URI_BOOKING))
                .when()
                .get("/booking/"+id)
                .then()
                .spec(BaseSpec.getBasicResponseSpec())
                .log()
                .ifError()
                .extract()
                .response();
    }

    public static Response updateBookingDetails(int id,Object updatedJson) {
        String token = TokenManager
                .getToken(ENV_PROPERTIES.getProperty("USERNAME_API"), ENV_PROPERTIES.getProperty("PASSWORD_API"));
//        String completeToken = "token="+token;
        return given(BaseSpec.getBasicRequestSpec(BASE_URI_BOOKING))
                .body(updatedJson)
                .header("Cookie","token="+token)
                .when()
                .put("/booking/"+id)
                .then()
                .spec(BaseSpec.getBasicResponseSpec())
                .log()
                .ifError()
                .extract()
                .response();
    }




}
