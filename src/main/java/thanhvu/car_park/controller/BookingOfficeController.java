package thanhvu.car_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanhvu.car_park.dto.BookingOfficeDto;
import thanhvu.car_park.dto.BookingOfficeListDto;
import thanhvu.car_park.service.BookingOfficeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/office")
public class BookingOfficeController {
    private BookingOfficeService bookingOfficeService;

    @Autowired
    public BookingOfficeController(BookingOfficeService bookingOfficeService) {
        this.bookingOfficeService = bookingOfficeService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookingOfficeListDto>> getAllOffice() {
        return ResponseEntity.ok(bookingOfficeService.getAllBookingsOffice());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOffice(@Valid @RequestBody BookingOfficeDto bookingOfficeDto) {
        bookingOfficeService.createNewOffice(bookingOfficeDto);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/edit/{officeId}")
    public ResponseEntity<?> editOffice(
            @Valid
            @RequestBody BookingOfficeDto bookingOfficeDto,
            @PathVariable("officeId") Long officeId
    ) {
        bookingOfficeService.editOffice(bookingOfficeDto, officeId);
        return ResponseEntity.ok("Cập nhật thành công tại vị trí id = " + officeId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOffice(@PathVariable Long id) {
        bookingOfficeService.deleteOfficeById(id);
        return ResponseEntity.ok("Xoá thành công tại vị trí id = " + id);
    }
}
