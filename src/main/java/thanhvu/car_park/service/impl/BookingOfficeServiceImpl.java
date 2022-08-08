package thanhvu.car_park.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thanhvu.car_park.dto.BookingOfficeDto;
import thanhvu.car_park.dto.BookingOfficeListDto;
import thanhvu.car_park.exception.NotFoundException;
import thanhvu.car_park.repository.BookingOfficeRepository;
import thanhvu.car_park.service.BookingOfficeService;

import java.util.List;

@Service
public class BookingOfficeServiceImpl implements BookingOfficeService {

    private BookingOfficeRepository bookingOfficeRepository;

    @Autowired
    public BookingOfficeServiceImpl(BookingOfficeRepository bookingOfficeRepository) {
        this.bookingOfficeRepository = bookingOfficeRepository;
    }

    @Override
    public List<BookingOfficeListDto> getAllBookingsOffice() {
        List<BookingOfficeListDto> bookingOfficeList = bookingOfficeRepository.getAllOffice();
        if (!bookingOfficeList.isEmpty()) {
            return bookingOfficeList;
        }
        throw new NotFoundException("Không có BookingsOffice nào");
    }

    @Override
    public void createNewOffice(BookingOfficeDto bookingOfficeDto) {
        bookingOfficeRepository.createNewOffice(
                bookingOfficeDto.getEndContractDeadline(),
                bookingOfficeDto.getOfficeName(),
                bookingOfficeDto.getOfficePhone(),
                bookingOfficeDto.getOfficePlace(),
                bookingOfficeDto.getOfficePrice(),
                bookingOfficeDto.getEndContractDeadline(),
                bookingOfficeDto.getOfficeTripId()
        );
    }

    @Override
    public boolean editOffice(BookingOfficeDto bookingOfficeDto, Long officeId) {
        if (bookingOfficeRepository.countId(officeId) > 0) {
            bookingOfficeRepository.editOffice(
                    bookingOfficeDto.getEndContractDeadline(),
                    bookingOfficeDto.getOfficeName(),
                    bookingOfficeDto.getOfficePhone(),
                    bookingOfficeDto.getOfficePlace(),
                    bookingOfficeDto.getOfficePrice(),
                    bookingOfficeDto.getEndContractDeadline(),
                    bookingOfficeDto.getOfficeTripId(),
                    officeId
            );
            return true;
        }
        throw new NotFoundException("Không tồn tại BookingOffice có id cần sửa");
    }

    @Override
    public boolean deleteOfficeById(Long officeId) {
        if (bookingOfficeRepository.countId(officeId) > 0) {
            bookingOfficeRepository.deleteOfficeById(officeId);
            return true;
        }
        throw new NotFoundException("Không tồn tại BookingOffice có id cần sửa");
    }
}

