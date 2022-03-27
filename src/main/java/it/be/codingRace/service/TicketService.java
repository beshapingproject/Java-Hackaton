package it.be.codingRace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<TicketDTO>> violations = validator.validate(ticket);
    if (!violations.isEmpty()) {
      List<String> violationMessages = new ArrayList<String>();
      for (ConstraintViolation<TicketDTO> violation : violations) {
        violationMessages.add(violation.getMessage());
      }
      String errorMessage = String.join(", ", violationMessages);
      throw new TicketException(errorMessage, Type.INVALID_REQUEST);
    }
  }
}
