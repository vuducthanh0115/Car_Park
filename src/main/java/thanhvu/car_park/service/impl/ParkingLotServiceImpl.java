package thanhvu.car_park.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thanhvu.car_park.dto.ParkingLotDto;
import thanhvu.car_park.entity.ParkingLot;
import thanhvu.car_park.exception.NotFoundException;
import thanhvu.car_park.repository.ParkingLotRepository;
import thanhvu.car_park.service.ParkingLotService;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public List<ParkingLot> getAllParkingLot() {
        List<ParkingLot> parkingLots = parkingLotRepository.getAllParkingLot();
        if (!parkingLots.isEmpty()) {
            return parkingLots;
        }
        throw new NotFoundException("Không có parkingLot nào");
    }

    @Override
    public void createNewParkingLot(ParkingLotDto parkingLotDto) {
        parkingLotRepository.createNewParkingLot(parkingLotDto.getArea(), parkingLotDto.getParkName(),
                parkingLotDto.getParkPlace(), parkingLotDto.getParkPrice(), parkingLotDto.getParkStatus());
    }

    @Override
    public boolean editParkingLot(ParkingLotDto parkingLotDto, Long packId) {
        if (parkingLotRepository.countId(packId) > 0) {
            parkingLotRepository.editParkingLot(
                    parkingLotDto.getArea(),
                    parkingLotDto.getParkName(),
                    parkingLotDto.getParkPlace(),
                    parkingLotDto.getParkPrice(),
                    parkingLotDto.getParkStatus(),
                    packId
            );
            return true;
        }
        throw new NotFoundException("Không tồn tại parkingLot tại id = " + packId);
    }

    @Override
    public boolean deleteParkingLotById(Long packId) {
        if (parkingLotRepository.countId(packId) > 0) {
            parkingLotRepository.deleteParkingLotById(packId);
            return true;
        }
        throw new NotFoundException("Không tồn tại parkingLot tại id = " + packId);

    }
}
