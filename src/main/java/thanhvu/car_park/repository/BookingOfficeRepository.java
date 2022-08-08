package thanhvu.car_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.car_park.dto.BookingOfficeListDto;
import thanhvu.car_park.entity.BookingOffice;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {

    @Query(value = """
            select bookingoffice.office_id as officeId, trip.destination as destination, bookingoffice.office_name as officeName, bookingoffice.office_phone as officePhone, bookingoffice.office_place as officePlace, bookingoffice.office_price as officePrice from bookingoffice
            join trip on bookingoffice.trip_id = trip.trip_id;
            """, nativeQuery = true)
    List<BookingOfficeListDto> getAllOffice();

    @Modifying
    @Query(value = """
            insert into bookingoffice(end_contract_deadline, office_name, office_phone, office_place, office_price, start_contract_deadline, trip_id) values (?1,?2,?3,?4,?5,?6,?7)
            """, nativeQuery = true)
    void createNewOffice(LocalDate endContractDeadline, String officeName, String officePhone, String officePlace,
                         Long officePrice, LocalDate startContractDeadline, Long trip);

    @Query("""
            select count(b) from BookingOffice b
            where b.officeId = ?1
            """)
    Integer countId(Long officeId);

    @Modifying
    @Query(value = """
            update bookingoffice as b
            set b.end_contract_deadline = ?1 , b.office_name = ?2 , b.office_phone = ?3 , b.office_place = ?4 , b.office_price = ?5 , b.start_contract_deadline = ?6 , b.trip_id = ?7 
            where b.office_id = ?8 ;
            """, nativeQuery = true)
    void editOffice(LocalDate endContractDeadline, String officeName, String officePhone, String officePlace,
                    Long officePrice, LocalDate startContractDeadline, Long trip, Long officeId);

    @Modifying
    @Query(value = """
            delete from bookingoffice
            where office_id = ?1 ;
            """, nativeQuery = true)
    void deleteOfficeById(Long officeId);


}
