package it.be.codingRace.dto;

import it.be.codingRace.exception.ErrorMessageDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadAttachmentResponseDTO {
  public static final String OK_STATUS = "OK";
  public static final String KO_STATUS = "KO";

  private String status;
  private Long attachmentId;

  private ErrorMessageDTO errorMessage;

  public UploadAttachmentResponseDTO(Long attachmentId) {
    super();
    this.status = OK_STATUS;
    this.attachmentId = attachmentId;
  }

  public UploadAttachmentResponseDTO(ErrorMessageDTO errorMessage) {
    super();
    this.status = KO_STATUS;
    this.errorMessage = errorMessage;
  }
}
