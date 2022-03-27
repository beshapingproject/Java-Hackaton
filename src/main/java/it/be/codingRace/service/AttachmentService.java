package it.be.codingRace.service;

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

  private void validateRequest(AttachmentDTO attachment) throws AttachmentException {
    String errorMessage = ValidatorUtils.validateRequestAndGetErrorMessage(attachment);
    if (errorMessage != null) {
      throw new AttachmentException(errorMessage, Type.INVALID_REQUEST);
    }
  }
}
