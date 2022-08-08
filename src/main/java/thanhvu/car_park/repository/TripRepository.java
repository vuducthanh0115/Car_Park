package thanhvu.car_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.car_park.dto.TripListDto;
import thanhvu.car_park.entity.Trip;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query(value = """
            select t from Trip t
            """)
    List<TripListDto> getAllTrip();

    @Modifying
    @Query(value = """
            insert into Trip(booked_ticket_number, car_type, departure_date, departure_time, destination, driver, maximum_online_ticket_number) 
            values (?1,?2,?3,?4,?5,?6,?7)
            """, nativeQuery = true)
    void createNewTrip(
            Integer bookedTicketNumber,
            String carType,
            LocalDate departureDate,
            LocalTime departureTime,
            String destination,
            String driver,
            Integer maximumOnlineTicket
    );

    @Modifying
    @Query(value = """
            update trip as t
            set t.booked_ticket_number = ?1 , t.car_type = ?2 , t.departure_date = ?3 , t.departure_time = ?4, t.destination = ?5, t.driver = ?6, t.maximum_online_ticket_number = ?7
            where t.trip_id = ?8 ;
            """, nativeQuery = true)
    void editTrip(
            Integer bookedTicketNumber,
            String carType,
            LocalDate departureDate,
            LocalTime departureTime,
            String destination,
            String driver,
            Integer maximumOnlineTicket,
            Long tripId
    );

    @Query("""
            select count(t) from Trip t
            where t.tripId = ?1
            """)
    Integer countId(Long tripId);

    @Modifying
    @Query(value = """
            delete from trip
            where trip_id = ?1 ;
            """, nativeQuery = true)
    void deleteTripById(Long tripId);
}
