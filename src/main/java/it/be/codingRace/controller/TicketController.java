package it.be.codingRace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.be.codingRace.dto.CreateTicketResponseDTO;
import it.be.codingRace.dto.TicketDTO;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.service.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController {

  @Autowired private TicketService ticketService;

  @RequestMapping(
      value = "/add",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CreateTicketResponseDTO> addTicket(@RequestBody TicketDTO ticket)
      throws TicketException {

    return ResponseEntity.status(HttpStatus.OK).body(ticketService.addTicket(ticket));
  }
}
