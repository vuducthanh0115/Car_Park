package thanhvu.car_park.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thanhvu.car_park.dto.TripDto;
import thanhvu.car_park.dto.TripListDto;
import thanhvu.car_park.entity.Trip;
import thanhvu.car_park.exception.NotFoundException;
import thanhvu.car_park.repository.TripRepository;
import thanhvu.car_park.service.TripService;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    private TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<TripListDto> getAllTrip() {
        List<TripListDto> trips = tripRepository.getAllTrip();
        if (!trips.isEmpty()) {
            return trips;
        }
        throw new NotFoundException("Không có trip nào");
    }

    @Override
    public void createNewTrip(TripDto tripDto) {
        tripRepository.createNewTrip(
                tripDto.getBookedTicketNumber(),
                tripDto.getCarType(),
                tripDto.getDepartureDate(),
                tripDto.getDepartureTime(),
                tripDto.getDestination(),
                tripDto.getDriver(),
                tripDto.getMaximumOnlineTicketNumber()
        );
    }

    @Override
    public boolean editTrip(TripDto tripDto, Long tripId) {
        if (tripRepository.countId(tripId) > 0) {
            tripRepository.editTrip(
                    tripDto.getBookedTicketNumber(),
                    tripDto.getCarType(),
                    tripDto.getDepartureDate(),
                    tripDto.getDepartureTime(),
                    tripDto.getDestination(),
                    tripDto.getDriver(),
                    tripDto.getMaximumOnlineTicketNumber(),
                    tripId
            );
            return true;
        }
        throw new NotFoundException("Không tồn tại trip có id = " + tripId);
    }

    @Override
    public boolean deleteTripById(Long tripId) {
        if (tripRepository.countId(tripId) > 0) {
            tripRepository.deleteTripById(tripId);
            return true;
        }
        throw new NotFoundException("Không tồn tại trip có id = " + tripId);
    }
}
