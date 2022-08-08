package thanhvu.car_park.dto;

import java.time.LocalTime;

public interface TicketGetDto {
    Long getTicketId();

    LocalTime getBookingTime();

    String getCustomerName();

    String getLicensePlate();

    Long getTripId();
}
