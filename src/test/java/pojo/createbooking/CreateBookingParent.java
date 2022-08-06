package pojo.createbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CreateBookingParent {
    private Object firstname;
    private Object lastname;
    private Object totalprice;
    private Object depositpaid;
    private Object additionalneeds;
    private BookingDates bookingdates;

}
