package thanhvu.car_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanhvu.car_park.dto.ParkingLotDto;
import thanhvu.car_park.entity.ParkingLot;
import thanhvu.car_park.service.ParkingLotService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/parkinglot")
public class ParkingLotController {
    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ParkingLot>> getAllParkingLot() {
        List<ParkingLot> parkingLot;
        parkingLot = parkingLotService.getAllParkingLot();
        if (parkingLot.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(parkingLot, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createParkingLot(@Valid @RequestBody ParkingLotDto parkingLotDto) {
        parkingLotService.createNewParkingLot(parkingLotDto);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editParkingLot(@Valid @RequestBody ParkingLotDto parkingLotDto, @PathVariable Long id) {
        parkingLotService.editParkingLot(parkingLotDto, id);
        return ResponseEntity.ok("Cập nhật thành công id = " + id);
    }

    @DeleteMapping("/delete/{park_id}")
    public ResponseEntity<?> deleteParkingLot(@PathVariable("park_id") Long parkId) {
        parkingLotService.deleteParkingLotById(parkId);
        return ResponseEntity.ok("Xoá thành công id = " + parkId);
    }
}
