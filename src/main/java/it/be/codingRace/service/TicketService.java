package it.be.codingRace.service;

import it.be.codingRace.dto.TicketFilterDTO;
import it.be.codingRace.entity.AttachmentEntity;
import it.be.codingRace.exception.AttachmentException;
import it.be.codingRace.repository.AttachmentRepository;
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

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private AttachmentService attachmentService;

  @Autowired
  EntityManager entityManager;

  public List<TicketResponseDTO> getTicketList(Long customerId, TicketFilterDTO filters){
    //TODO: check if customer exists

  List<TicketEntity> ticketEntityList = entityManager.createQuery(getCriteriaFromTicketFilterDTO(customerId, filters)).getResultList();
  return ticketEntityList.stream().map(t -> {
              TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
              BeanUtils.copyProperties(t, ticketResponseDTO);
              return ticketResponseDTO;
            })
        .collect(Collectors.toList());
  }

  private CriteriaQuery<TicketEntity> getCriteriaFromTicketFilterDTO(Long customerId, TicketFilterDTO filters){

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<TicketEntity> criteriaQuery = cb.createQuery(TicketEntity.class);
    Root<TicketEntity> ticketEntityRoot = criteriaQuery.from(TicketEntity.class);

    List<Predicate> predicates = new ArrayList<>();
    predicates.add(cb.equal(ticketEntityRoot.get("customerEntity"), customerId));
    if(filters.getCreationDateFrom() != null) {
      predicates.add(cb.greaterThanOrEqualTo(ticketEntityRoot.get("creationDate"), filters.getCreationDateFrom()));
    }
    if(filters.getCreationDateTo() != null) {
      predicates.add(cb.lessThanOrEqualTo(ticketEntityRoot.get("creationDate"), filters.getCreationDateTo()));
    }
    criteriaQuery.where(predicates.toArray(new Predicate[0]));
    return criteriaQuery;
  }




  public TicketResponseDTO addTicket(Long customerId, TicketRequestDTO ticketDTO) throws TicketException {
    //TODO: check if customer exists

    TicketEntity ticketEntity = new TicketEntity();
    try {
      if(ticketDTO.getAttachmentIds() != null && !ticketDTO.getAttachmentIds().isEmpty()) {
        List<AttachmentEntity> attachmentEntityList = attachmentService.checkIfAttachmentsExist(ticketDTO.getAttachmentIds());
        ticketEntity.setAttachmentEntityList(attachmentEntityList);
      }
    } catch (AttachmentException e) {
      throw new TicketException("Attachments not present for ticket", TicketException.Type.ENTITY_NOT_FOUND);
    }
    BeanUtils.copyProperties(ticketDTO, ticketEntity);
    ticketEntity.setCreated(new Date());
    ticketEntity.setStatus(Constants.NEW.getValue());
    ticketRepository.save(ticketEntity);

    BeanUtils.copyProperties(ticketEntity, ticketDTO);
    return new TicketResponseDTO(ticketEntity.getId());
  }

  public TicketResponseDTO updateTicket(Long customerId, TicketRequestDTO ticketDTO) throws TicketException {
    //TODO: check if customer exists

    if(ticketDTO.getStatus().equalsIgnoreCase(Constants.CLOSED.getValue())){
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
