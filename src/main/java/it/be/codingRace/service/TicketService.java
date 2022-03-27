package it.be.codingRace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.be.codingRace.dto.CreateTicketResponseDTO;
import it.be.codingRace.dto.TicketDTO;
import it.be.codingRace.entity.TicketEntity;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.exception.TicketException.Type;
import it.be.codingRace.repository.TicketRepository;
import it.be.codingRace.utils.ValidatorUtils;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class TicketService {

  @Autowired private TicketRepository ticketRepository;

  public CreateTicketResponseDTO addTicket(TicketDTO ticket) throws TicketException {
    validateRequest(ticket);
    PropertyMapper map = PropertyMapper.get();
    TicketEntity ticketEntity = new TicketEntity();

    map.from(ticket::getSubject).to(ticketEntity::setSubject);
    map.from(ticket::getContent).to(ticketEntity::setContent);

    ticketRepository.save(ticketEntity);

    return new CreateTicketResponseDTO(ticketEntity.getId());
  }

  private void validateRequest(TicketDTO ticket) throws TicketException {
    String errorMessage = ValidatorUtils.validateRequestAndGetErrorMessage(ticket);
    if (errorMessage != null) {
      throw new TicketException(errorMessage, Type.INVALID_REQUEST);
    }
  }
}
