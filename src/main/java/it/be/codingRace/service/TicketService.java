package it.be.codingRace.service;

import it.be.codingRace.utils.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.be.codingRace.dto.TicketResponseDTO;
import it.be.codingRace.dto.TicketRequestDTO;
import it.be.codingRace.entity.TicketEntity;
import it.be.codingRace.exception.TicketException;
import it.be.codingRace.exception.TicketException.Type;
import it.be.codingRace.repository.TicketRepository;
import it.be.codingRace.utils.ValidatorUtils;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;

  public TicketResponseDTO addTicket(Long customerId, TicketRequestDTO ticketDTO) throws TicketException {
    //TODO: check if customer exists
    TicketEntity ticketEntity = new TicketEntity();

    BeanUtils.copyProperties(ticketDTO, ticketEntity);
    ticketEntity.setCreated(new Date());
    ticketEntity.setStatus(Constants.NEW.getValue());
    ticketRepository.save(ticketEntity);

    BeanUtils.copyProperties(ticketEntity, ticketDTO);
    return new TicketResponseDTO(ticketEntity.getId());
  }

  public TicketResponseDTO updateTicket(Long customerId, TicketRequestDTO ticketDTO) throws TicketException {
    //TODO: check if customer exists
    if(ticketDTO.getStatus().equals(Constants.CLOSED.getValue())){
      throw new TicketException("Ticket already closed.", Type.INVALID_REQUEST);
    }
    Optional<TicketEntity> optionalTicketEntity = ticketRepository.findById(ticketDTO.getId());
    if(!optionalTicketEntity.isPresent()){
        throw new TicketException("Entity not found.", Type.ENTITY_NOT_FOUND);
    }

    TicketEntity ticketEntity = optionalTicketEntity.get();
    BeanUtils.copyProperties(ticketDTO, ticketEntity);
    ticketEntity.setUpdated(new Date());
    ticketRepository.save(ticketEntity);

    return new TicketResponseDTO(ticketEntity.getId());
  }


}
