package it.be.codingRace.service;

import org.springframework.stereotype.Service;

import it.be.codingRace.dto.AttachmentDTO;
import it.be.codingRace.exception.AttachmentException;
import it.be.codingRace.exception.AttachmentException.Type;
import it.be.codingRace.utils.ValidatorUtils;

@Service
public class AttachmentService {

  public String uploadAttachment(AttachmentDTO attachment) throws AttachmentException {
    validateRequest(attachment);
    return null;
  }

  private void validateRequest(AttachmentDTO attachment) throws AttachmentException {
    String errorMessage = ValidatorUtils.validateRequestAndGetErrorMessage(attachment);
    if (errorMessage != null) {
      throw new AttachmentException(errorMessage, Type.INVALID_REQUEST);
    }
  }
}
