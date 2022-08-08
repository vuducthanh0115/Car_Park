package thanhvu.car_park.service;

import thanhvu.car_park.dto.ParkingLotDto;
import thanhvu.car_park.entity.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLot> getAllParkingLot();

    void createNewParkingLot(ParkingLotDto parkingLotDto);

    boolean editParkingLot(ParkingLotDto parkingLotDto, Long packId);

    boolean deleteParkingLotById(Long packId);
}
