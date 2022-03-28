package it.be.codingRace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.be.codingRace.dto.AttachmentDTO;
import it.be.codingRace.dto.UploadAttachmentResponseDTO;
import it.be.codingRace.entity.AttachmentEntity;
import it.be.codingRace.exception.AttachmentException;
import it.be.codingRace.exception.AttachmentException.Type;
import it.be.codingRace.repository.AttachmentRepository;
import it.be.codingRace.utils.ValidatorUtils;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class AttachmentService {

  @Autowired private AttachmentRepository attachmentRepository;

  public UploadAttachmentResponseDTO uploadAttachment(AttachmentDTO attachment)
      throws AttachmentException {
    validateRequest(attachment);

    PropertyMapper map = PropertyMapper.get();
    AttachmentEntity attachmentEntity = new AttachmentEntity();

    map.from(attachment::getFileName).to(attachmentEntity::setFileName);
    map.from(attachment::getContentType).to(attachmentEntity::setContentType);
    map.from(attachment::getSize).to(attachmentEntity::setSize);
    map.from(attachment::getBody).to(attachmentEntity::setBody);

    attachmentRepository.save(attachmentEntity);

    return new UploadAttachmentResponseDTO(attachmentEntity.getId());
  }

  public AttachmentDTO getAttachment(Long attachmentId) throws AttachmentException {
    // TODO check on user

    assertAttachmentIdNotNull(attachmentId);
    Optional<AttachmentEntity> attachmentOptional = attachmentRepository.findById(attachmentId);
    assertAttachmentIsPresent(attachmentOptional);

    PropertyMapper map = PropertyMapper.get();
    AttachmentEntity attachmentEntity = attachmentOptional.get();
    AttachmentDTO attachmentDto = new AttachmentDTO();

    map.from(attachmentEntity::getFileName).to(attachmentDto::setFileName);
    map.from(attachmentEntity::getContentType).to(attachmentDto::setContentType);
    map.from(attachmentEntity::getSize).to(attachmentDto::setSize);
    map.from(attachmentEntity::getBody).to(attachmentDto::setBody);

    return attachmentDto;
  }

  private void validateRequest(AttachmentDTO attachment) throws AttachmentException {
    String errorMessage = ValidatorUtils.validateRequestAndGetErrorMessage(attachment);
    if (errorMessage != null) {
      throw new AttachmentException(errorMessage, Type.INVALID_REQUEST);
    }
  }

  public List<AttachmentEntity> checkIfAttachmentsExist(List<Long> attachmentIds)
      throws AttachmentException {
    List<AttachmentEntity> attachmentEntityList = attachmentRepository.findByIdIn(attachmentIds);
    if (attachmentEntityList.isEmpty()) {
      throw new AttachmentException(
          "Attachments not found", AttachmentException.Type.ENTITY_NOT_FOUND);
    }
    return attachmentEntityList;
  }

  private void assertAttachmentIdNotNull(Long attachmentId) throws AttachmentException {
    if (attachmentId == null) {
      throw new AttachmentException(
          "Null attachmentId", AttachmentException.Type.NULL_ATTACHMENT_ID);
    }
  }

  private void assertAttachmentIsPresent(Optional<AttachmentEntity> attachment)
      throws AttachmentException {
    if (attachment.isEmpty()) {
      throw new AttachmentException(
          "No attachment found", AttachmentException.Type.ENTITY_NOT_FOUND);
    }
  }
}
