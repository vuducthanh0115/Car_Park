package thanhvu.car_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.car_park.entity.ParkingLot;

import java.util.List;

@Transactional
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    @Query(value = """
            select p from ParkingLot p
            """)
    List<ParkingLot> getAllParkingLot();

    @Modifying
    @Query(value = """
            insert into parkinglot(area, park_name, park_place, park_price, park_status) values (?1,?2,?3,?4,?5)
            """, nativeQuery = true)
    void createNewParkingLot(Long area, String packName, String packPlace, Long packPrice, String packStatus);

    @Query("""
            select count(p) from ParkingLot p
            where p.parkId = ?1
            """)
    Integer countId(Long parkId);

    @Modifying
    @Query(value = """
            update parkinglot as p
            set p.area = ?1 , p.park_name = ?2 , p.park_place = ?3 , p.park_price = ?4 , p.park_status = ?5
            where p.park_id = ?6 ;
            """, nativeQuery = true)
    void editParkingLot(Long area, String parkName, String parkPlace, Long parkPrice, String parkStatus, Long
            parkId);

    @Modifying
    @Query(value = """
            delete from parkinglot
            where park_id = ?1 ;
            """, nativeQuery = true)
    void deleteParkingLotById(Long parkId);
}
