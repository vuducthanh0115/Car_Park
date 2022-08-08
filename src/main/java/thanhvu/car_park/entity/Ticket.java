package thanhvu.car_park.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", nullable = false)
    private Long ticketId;

    @Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "customer_name", length = 25, nullable = false)
    private String customerName;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "license_plate", nullable = false, foreignKey = @ForeignKey(name = "fk_license_plate"))
    @JsonBackReference
    private Car licensePlateId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "trip_id", nullable = false, foreignKey = @ForeignKey(name = "fk_trip_id_ticket"))
    @JsonBackReference
    private Trip ticketTripId;

    public Ticket() {
    }

    public Ticket(Long ticketId, LocalTime bookingTime, String customerName, Car licensePlateId, Trip ticketTripId) {
        this.ticketId = ticketId;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlateId = licensePlateId;
        this.ticketTripId = ticketTripId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Car getLicensePlateId() {
        return licensePlateId;
    }

    public void setLicensePlateId(Car licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    public Trip getTicketTripId() {
        return ticketTripId;
    }

    public void setTicketTripId(Trip ticketTripId) {
        this.ticketTripId = ticketTripId;
    }
}
