package thanhvu.car_park.service;

import thanhvu.car_park.dto.TicketDto;
import thanhvu.car_park.dto.TicketGetDto;

import java.util.List;

public interface TicketService {
    List<TicketGetDto> getAllTicket();

    void createNewTicket(TicketDto ticketDto);

    boolean editTicket(TicketDto ticketDto, Long ticketId);

    boolean deleteTicketById(Long ticketId);
}
