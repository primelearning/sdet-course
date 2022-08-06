package apiutils;

import configurations.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class BaseSpec {
    private BaseSpec(){}

    public static RequestSpecification getBasicRequestSpec(String BaseUri) {
        return new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter(ApiLogger.getPrintStream()))
                .addFilter(new ResponseLoggingFilter(ApiLogger.getPrintStream()))
                .setContentType(ContentType.JSON)
                .setBaseUri(BaseUri)
                .build();
    }
    public static ResponseSpecification getBasicResponseSpec() {
        return new ResponseSpecBuilder()
                .build();
    }


}
