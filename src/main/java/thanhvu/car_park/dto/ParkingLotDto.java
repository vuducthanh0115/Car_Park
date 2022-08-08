package thanhvu.car_park.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParkingLotDto {
    private Long parkId;
    @NotNull(message = "Area can not be empty")
    private Long area;
    @NotEmpty(message = "Name can not be empty")
    private String parkName;
    @NotEmpty(message = "Place can not be empty")
    private String parkPlace;
    @NotNull(message = "Price can not be null")
    private Long parkPrice;
    @NotEmpty(message = "Status can not be empty")
    private String parkStatus;

    public ParkingLotDto() {
    }

    public ParkingLotDto(Long parkId, Long area, String parkName, String parkPlace, Long parkPrice, String parkStatus) {
        this.parkId = parkId;
        this.area = area;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;
        this.parkStatus = parkStatus;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
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

