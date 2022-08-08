package thanhvu.car_park.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarDto {
    private String licensePlate;

    @NotEmpty(message = "Car type can not be empty")
    private String carType;
    @NotEmpty(message = "Car color can not be empty")
    private String carColor;
    @NotEmpty(message = "Company can not be empty")
    private String company;
    @NotNull(message = "ParkingLot can not be null")
    private Long parkingLotId;

    public CarDto() {
    }

    public CarDto(String licensePlate, String carType, String carColor, String company, Long parkingLotId) {
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.carColor = carColor;
        this.company = company;
        this.parkingLotId = parkingLotId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
