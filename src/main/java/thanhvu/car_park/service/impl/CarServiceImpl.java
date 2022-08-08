package thanhvu.car_park.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thanhvu.car_park.dto.CarDto;
import thanhvu.car_park.entity.Car;
import thanhvu.car_park.exception.DuplicateRecordException;
import thanhvu.car_park.exception.NotFoundException;
import thanhvu.car_park.repository.CarRepository;
import thanhvu.car_park.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCar() {
        List<Car> carList = carRepository.getAllCar();
        if (!carList.isEmpty()) {
            return carList;
        }
        throw new NotFoundException("Không có Car nào");
    }

    @Override
    public boolean createNewCar(CarDto carDto) {
        int countId = carRepository.countLicensePlate(carDto.getLicensePlate());
        if(countId < 1){
            carRepository.createNewCar(
                    carDto.getLicensePlate(),
                    carDto.getCarType(),
                    carDto.getCarColor(),
                    carDto.getCompany(),
                    carDto.getParkingLotId()
            );
            return true;
        }
        throw new DuplicateRecordException("Biển số xe đã tồn tại");
    }

    @Override
    public void editCar(CarDto carDto, String licensePlate) {
        carRepository.editCar(
                carDto.getCarType(),
                carDto.getCarColor(),
                carDto.getCompany(),
                carDto.getParkingLotId(),
                licensePlate
        );
    }

    @Override
    public void deleteCarByLicensePlate(String licensePlate) {
        carRepository.deleteCarByLicensePlate(licensePlate);
    }
}
