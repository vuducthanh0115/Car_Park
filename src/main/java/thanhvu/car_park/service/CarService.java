package thanhvu.car_park.service;

import thanhvu.car_park.dto.CarDto;
import thanhvu.car_park.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();

    boolean createNewCar(CarDto carDto);

    void editCar(CarDto carDto, String licensePlate);

    void deleteCarByLicensePlate(String licensePlate);
}
