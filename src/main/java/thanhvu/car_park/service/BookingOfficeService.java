package thanhvu.car_park.service;

import thanhvu.car_park.dto.BookingOfficeDto;
import thanhvu.car_park.dto.BookingOfficeListDto;

import java.util.List;

public interface BookingOfficeService {
    List<BookingOfficeListDto> getAllBookingsOffice();

    void createNewOffice(BookingOfficeDto bookingOfficeDto);

    boolean editOffice(BookingOfficeDto bookingOfficeDto, Long officeId);

    boolean deleteOfficeById(Long officeId);
}
