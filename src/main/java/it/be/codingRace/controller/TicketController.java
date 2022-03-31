package it.be.codingRace.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.be.codingRace.dto.TicketFilterDTO;
import it.be.codingRace.dto.TicketRequestDTO;
import it.be.codingRace.dto.TicketResponseDTO;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.service.TicketService;
import it.be.codingRace.utils.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

  @Autowired private TicketService ticketService;

  @PostMapping("/list/{customerId}")
  @ApiOperation(value = "", notes = "GET TICKET LIST")
  public List<TicketResponseDTO> getTicketList(@PathVariable Long customerId, @Valid @RequestBody TicketFilterDTO filters)
      throws TicketException {
    return ticketService.getTicketList(customerId, filters);
  }

  @PostMapping("/add/{customerId}")
  @ApiOperation(value = "", notes = "ADD NEW TICKET")
  public TicketResponseDTO addTicket(@PathVariable Long customerId, @Valid @RequestBody TicketRequestDTO ticket)
      throws TicketException {
    return ticketService.addTicket(1L, ticket);
  }

  @PostMapping("/update/{customerId}")
  @ApiOperation(value = "", notes = "UPDATE TICKET")
  public TicketResponseDTO updateTicket(@PathVariable Long customerId, @Valid @RequestBody TicketRequestDTO ticket)
      throws TicketException {
    return ticketService.updateTicket(customerId, ticket);
  }

  @GetMapping("/detail/{customerId}/{id}")
  @ResponseBody
  @ApiOperation(value = "", notes = "GET DETAILED TICKET")
  public TicketResponseDTO getDetailedTicket(@PathVariable Long customerId, @PathVariable Long id)
          throws TicketException {
    return ticketService.getDetailedTicket(customerId, id);
  }


}
