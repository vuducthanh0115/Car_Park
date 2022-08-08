package thanhvu.car_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.car_park.entity.Car;

import java.util.List;

@Transactional
public interface CarRepository extends JpaRepository<Car, String> {
    @Query(value = """
            select c, park.parkName from Car c
            join c.parkingLotId park
            """)
    List<Car> getAllCar();

    @Query(value = """
            select count(*) from car where license_plate = ?1 
            """, nativeQuery = true)
    Integer countLicensePlate(String licensePlate);

    @Modifying
    @Query(value = """
            insert into car(license_plate, car_color, car_type, company, park_id) values (?1,?2,?3,?4,?5)
            """, nativeQuery = true)
    void createNewCar(String licensePlate, String carColor, String carType, String company, Long parkingLot);

    @Modifying
    @Query(value = """
            update car as c
            set c.car_color = ?1 , c.car_type = ?2 , c.company = ?3 , c.park_id = ?4 
            where c.license_plate = ?5 ;
            """, nativeQuery = true)
    void editCar(String carColor, String carType, String company, Long parkingLot, String licensePlate);

    @Modifying
    @Query(value = """
            delete from car
            where license_plate = ?1 ;
            """, nativeQuery = true)
    void deleteCarByLicensePlate(String licensePlate);
}
