package thanhvu.car_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanhvu.car_park.dto.TicketDto;
import thanhvu.car_park.dto.TicketGetDto;
import thanhvu.car_park.service.TicketService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TicketGetDto>> getAllTicket() {
        List<TicketGetDto> ticketGetDto;
        ticketGetDto = ticketService.getAllTicket();
        if (ticketGetDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketGetDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTicket(@Valid @RequestBody TicketDto ticketDto) {
        ticketService.createNewTicket(ticketDto);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editTicket(@Valid @RequestBody TicketDto ticketDto, @PathVariable("id") Long ticketId) {
        ticketService.editTicket(ticketDto, ticketId);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/delete/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicketById(ticketId);
        return ResponseEntity.ok("Xoá thành công");
    }
}
