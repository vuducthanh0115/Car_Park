package thanhvu.car_park.dto;

import thanhvu.car_park.entity.BookingOffice;
import thanhvu.car_park.entity.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface TripListDto {
    Long getTripId();
    Integer getBookedTicketNumber();
    String getCarType();
    LocalDate getDepartureDate();
    LocalTime getDepartureTime();
    String getDestination();
    String getDriver();
    Integer getMaximumOnlineTicketNumber();
    Set<BookingOffice> getBookingOfficeList();
    Set<Ticket> getTicketTrip();
}
