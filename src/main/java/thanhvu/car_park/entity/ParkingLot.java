package thanhvu.car_park.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parkinglot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id", nullable = false)
    private Long parkId;

    @Column(name = "area", nullable = false)
    private Long area;

    @Column(name = "park_name", length = 50, nullable = false)
    private String parkName;

    @Column(name = "park_place", length = 11, nullable = false)
    private String parkPlace;

    @Column(name = "park_price", nullable = false)
    private Long parkPrice;

    @Column(name = "park_status", length = 50, nullable = false)
    private String parkStatus;

    @OneToMany(mappedBy = "parkingLotId" )
    @JsonManagedReference
    private Set<Car> carList;

    public ParkingLot() {
    }

    public ParkingLot(Long parkId, Long area, String parkName, String parkPlace, Long parkPrice, String parkStatus, Set<Car> carList) {
        this.parkId = parkId;
        this.area = area;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;
        this.parkStatus = parkStatus;
        this.carList = carList;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Set<Car> getCarList() {
        return carList;
    }

    public void setCarList(Set<Car> carList) {
        this.carList = carList;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(Long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

}
