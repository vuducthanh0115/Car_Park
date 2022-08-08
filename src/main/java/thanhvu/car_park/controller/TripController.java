package thanhvu.car_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanhvu.car_park.dto.TripDto;
import thanhvu.car_park.dto.TripListDto;
import thanhvu.car_park.entity.Trip;
import thanhvu.car_park.service.TripService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripController {
    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TripListDto>> getAllTrip() {
        return ResponseEntity.ok(tripService.getAllTrip());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTicket(@Valid @RequestBody TripDto tripDto) {
        tripService.createNewTrip(tripDto);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editTicket(@Valid @RequestBody TripDto tripDto,
                                        @PathVariable("id") Long tripId) {
        tripService.editTrip(tripDto, tripId);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/delete/{tripId}")
    public ResponseEntity<?> deleteTicket(@PathVariable("tripId") Long tripId) {
        tripService.deleteTripById(tripId);
        return ResponseEntity.ok("Xoá thành công");
    }
}
