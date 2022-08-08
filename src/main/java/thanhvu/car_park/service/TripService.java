package thanhvu.car_park.service;

import thanhvu.car_park.dto.TripDto;
import thanhvu.car_park.dto.TripListDto;

import java.util.List;

public interface TripService {
    List<TripListDto> getAllTrip();

    void createNewTrip(TripDto tripDto);

    boolean editTrip(TripDto tripDto, Long tripId);

    boolean deleteTripById(Long tripId);
}
