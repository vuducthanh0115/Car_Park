package thanhvu.car_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.car_park.dto.TicketGetDto;
import thanhvu.car_park.entity.Ticket;

import java.time.LocalTime;
import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = """
            select ticket.ticket_id as ticketId, ticket.booking_time as bookingTime, ticket.customer_name as customerName, ticket.license_plate as licensePlate, ticket.trip_id as tripId from ticket;
            """, nativeQuery = true)
    List<TicketGetDto> getAllTicket();

    @Modifying
    @Query(value = """
            insert into ticket(booking_time, customer_name, license_plate, trip_id) values (?1,?2,?3,?4)
            """, nativeQuery = true)
    void createNewTicket(LocalTime bookingTime, String customerName, String licensePlate, Long tripId);

    @Query("""
            select count(t) from Ticket t
            where t.ticketId = ?1
            """)
    Integer countId(Long ticketId);

    @Transactional
    @Modifying
    @Query(value = """
            update ticket as t
            set t.booking_time = ?1 , t.customer_name = ?2 , t.license_plate = ?3 , t.trip_id = ?4
            where t.ticket_id = ?5 ;
            """, nativeQuery = true)
    void editTicket(LocalTime bookingTime, String customerName, String licensePlate, Long tripId, Long ticketId);

    @Transactional
    @Modifying
    @Query(value = """
            delete from ticket
            where ticket_id = ?1 ;
            """, nativeQuery = true)
    void deleteTicketById(Long ticketId);
}
