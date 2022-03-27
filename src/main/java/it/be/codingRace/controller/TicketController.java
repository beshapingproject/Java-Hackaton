package it.be.codingRace.controller;

import it.be.codingRace.utils.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.be.codingRace.dto.CreateTicketResponseDTO;
import it.be.codingRace.dto.TicketDTO;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.service.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController {

  @Autowired
  private TicketService ticketService;

  @PostMapping("/add")
  /*public ResponseEntity<CreateTicketResponseDTO> addTicket(@RequestBody TicketDTO ticket) throws TicketException {*/
  /*return ResponseEntity.status(HttpStatus.OK).body(ticketService.addTicket(ticket));*/
  public ResponseEntity<JsonResponseBody> addTicket(@RequestBody TicketDTO ticket) throws TicketException {
    return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),ticketService.addTicket(ticket)));
  }
}
