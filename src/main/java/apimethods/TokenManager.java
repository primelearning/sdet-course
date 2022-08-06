package apimethods;

import apiutils.BaseSpec;
import configurations.ConfigManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public final class TokenManager {
    private TokenManager(){}
    private static final String BASE_URI_BOOKING  = ConfigManager.ENV_PROPERTIES.getProperty("BASE_URL_API");

    public static String getToken(String username, String password){
        HashMap<String,String> credentials = new HashMap<>();
        credentials.put("username",username);
        credentials.put("password",password);

        return given(BaseSpec.getBasicRequestSpec(BASE_URI_BOOKING))
                .body(credentials)
                .when()
                .post("/auth")
                .then()
                .spec(BaseSpec.getBasicResponseSpec())
                .log()
                .ifError()
                .extract().path("token");
    }

}
