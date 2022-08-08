package thanhvu.car_park.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", nullable = false)
    private Long tripId;

    @Column(name = "booked_ticket_number", nullable = false)
    private Integer bookedTicketNumber;

    @Column(name = "car_type", length = 50, nullable = false)
    private String carType;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "destination", length = 50, nullable = false)
    private String destination;

    @Column(name = "driver", length = 25, nullable = false)
    private String driver;

    @Column(name = "maximum_online_ticket_number", nullable = false)
    private Integer maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "officeTripId" )
    @JsonManagedReference
    private Set<BookingOffice> bookingOfficeList;

    @OneToMany(mappedBy = "ticketTripId")
    @JsonManagedReference
    private Set<Ticket> ticketTrip;

    public Trip(Long tripId, Integer bookedTicketNumber, String carType, LocalDate departureDate, LocalTime departureTime, String destination, String driver, Integer maximumOnlineTicketNumber, Set<BookingOffice> bookingOfficeList, Set<Ticket> ticketTrip) {
        this.tripId = tripId;
        this.bookedTicketNumber = bookedTicketNumber;
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
        this.bookingOfficeList = bookingOfficeList;
        this.ticketTrip = ticketTrip;
    }

    public Trip() {
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Integer getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(Integer bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(Integer maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public Set<BookingOffice> getBookingOfficeList() {
        return bookingOfficeList;
    }

    public void setBookingOfficeList(Set<BookingOffice> bookingOfficeList) {
        this.bookingOfficeList = bookingOfficeList;
    }

    public Set<Ticket> getTicketTrip() {
        return ticketTrip;
    }

    public void setTicketTrip(Set<Ticket> ticketTrip) {
        this.ticketTrip = ticketTrip;
    }
}
