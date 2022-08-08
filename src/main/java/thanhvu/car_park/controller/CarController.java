package thanhvu.car_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanhvu.car_park.dto.CarDto;
import thanhvu.car_park.entity.Car;
import thanhvu.car_park.service.CarService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Car>> getAllCar() {
        return ResponseEntity.ok(carService.getAllCar());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCar(@Valid @RequestBody CarDto carDto) {
        carService.createNewCar(carDto);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/edit/{licensePlate}")
    public ResponseEntity<?> editCar(@Valid @RequestBody CarDto carDto, @PathVariable("licensePlate") String licensePlate) {
        carService.editCar(carDto, licensePlate);
        return ResponseEntity.ok("Cập nhật thành công ");
    }

    @DeleteMapping("/delete/{licensePlate}")
    public ResponseEntity<?> deleteCar(@PathVariable("licensePlate") String licensePlate) {
        carService.deleteCarByLicensePlate(licensePlate);
        return ResponseEntity.ok("Xoá thành công");
    }
}
