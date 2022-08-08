package thanhvu.car_park.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thanhvu.car_park.dto.TicketDto;
import thanhvu.car_park.dto.TicketGetDto;
import thanhvu.car_park.exception.NotFoundException;
import thanhvu.car_park.repository.TicketRepository;
import thanhvu.car_park.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketGetDto> getAllTicket() {
        List<TicketGetDto> tickets = ticketRepository.getAllTicket();
        if (!tickets.isEmpty()) {
            return tickets;
        }
        throw new NotFoundException("Không có ticket nào");
    }

    @Override
    public void createNewTicket(TicketDto ticketDto) {
        ticketRepository.createNewTicket(
                ticketDto.getBookingTime(),
                ticketDto.getCustomerName(),
                ticketDto.getLicensePlateId(),
                ticketDto.getTicketTripId()
        );
    }

    @Override
    public boolean editTicket(TicketDto ticketDto, Long ticketId) {
        if (ticketRepository.countId(ticketId) > 0) {
            ticketRepository.editTicket(ticketDto.getBookingTime(),
                    ticketDto.getCustomerName(),
                    ticketDto.getLicensePlateId(),
                    ticketDto.getTicketTripId(),
                    ticketId
            );
            return true;
        }
        throw new NotFoundException("Không tồn tại ticket có id = " + ticketId);
    }

    @Override
    public boolean deleteTicketById(Long ticketId) {
        if (ticketRepository.countId(ticketId) > 0) {
            ticketRepository.deleteTicketById(ticketId);
            return true;
        }
        throw new NotFoundException("Không tồn tại ticket có id = " + ticketId);
    }
}
