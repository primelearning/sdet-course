package pojo.createbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class BookingDates {
    private Object checkin;
    private Object checkout;
}
