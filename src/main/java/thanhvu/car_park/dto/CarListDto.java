package thanhvu.car_park.dto;

import thanhvu.car_park.entity.ParkingLot;
import thanhvu.car_park.entity.Ticket;

import java.util.Set;

public interface CarListDto {
    String getLicensePlate();

    String getCarType();

    String getCompany();

    ParkingLot getParkingLotId();

    Set<Ticket> getTicketCar();
}
