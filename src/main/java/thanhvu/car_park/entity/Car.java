package thanhvu.car_park.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "license_plate", nullable = false, length = 50)
    private String licensePlate;

    @Column(name = "car_color", length = 11, nullable = false)
    private String carColor;

    @Column(name = "car_type", length = 50, nullable = false)
    private String carType;

    @Column(name = "company", length = 50, nullable = false)
    private String company;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "park_id", nullable = false, foreignKey = @ForeignKey(name = "fk_park_id"))
    @JsonBackReference
    private ParkingLot parkingLotId;

    @OneToMany(mappedBy = "licensePlateId")
    @JsonManagedReference
    private Set<Ticket> ticketCar;

    public Car() {
    }

    public Car(String licensePlate, String carColor, String carType, String company, ParkingLot parkingLotId, Set<Ticket> ticketCar) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
        this.parkingLotId = parkingLotId;
        this.ticketCar = ticketCar;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public ParkingLot getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(ParkingLot parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Set<Ticket> getTicketCar() {
        return ticketCar;
    }

    public void setTicketCar(Set<Ticket> ticketCar) {
        this.ticketCar = ticketCar;
    }
}
