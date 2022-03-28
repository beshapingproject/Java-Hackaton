package it.be.codingRace.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.be.codingRace.dto.TicketFilterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.be.codingRace.dto.TicketRequestDTO;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.service.TicketService;
import it.be.codingRace.utils.JsonResponseBody;

import javax.validation.Valid;

@RestController
@RequestMapping("ticket")
public class TicketController {

  @Autowired private TicketService ticketService;

  @PostMapping("/list")
  @ApiOperation(value = "", notes = "GET TICKET LIST")
  public ResponseEntity<JsonResponseBody> getTicketList(@ApiParam(name = "CUSTOMER", value = "Customer Id") @PathVariable Long customerId,  @ApiParam(name = "TICKET", value = "Ticket Body") @Valid @RequestBody TicketFilterDTO filters) throws TicketException {
    return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ticketService.getTicketList(customerId, filters)));
  }

  @PostMapping("/add")
  @ApiOperation(value = "", notes = "ADD NEW TICKET")
  public ResponseEntity<JsonResponseBody> addTicket(@ApiParam(name = "CUSTOMER", value = "Customer Id") @PathVariable Long customerId,  @ApiParam(name = "TICKET", value = "Ticket Body") @Valid @RequestBody TicketRequestDTO ticket) throws TicketException {
    return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ticketService.addTicket(customerId, ticket)));
  }

  @PostMapping("/update")
  @ApiOperation(value = "", notes = "UPDATE TICKET")
  public ResponseEntity<JsonResponseBody> updateTicket(@ApiParam(name = "CUSTOMER", value = "Customer Id") @PathVariable Long customerId,  @ApiParam(name = "TICKET", value = "Ticket Body") @Valid @RequestBody TicketRequestDTO ticket) throws TicketException {
    return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ticketService.updateTicket(customerId, ticket)));
  }

}
