package it.be.codingRace.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.be.codingRace.dto.TicketDTO;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.service.TicketService;
import it.be.codingRace.utils.JsonResponseBody;

@RestController
@RequestMapping("ticket")
public class TicketController {

  @Autowired private TicketService ticketService;

  @PostMapping("/add")
  @ApiOperation(value = "", notes = "CREAZIONE NUOVO TICKET")
  public ResponseEntity<JsonResponseBody> addTicket(@ApiParam(name = "TICKET", value = "Ticket Body") @RequestBody TicketDTO ticket) throws TicketException {

    return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ticketService.addTicket(ticket)));
  }
}
