package it.be.codingRace.dto;

import it.be.codingRace.exception.ErrorMessageDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketResponseDTO {
  public static final String OK_STATUS = "OK";
  public static final String KO_STATUS = "KO";

  private String status;
  private Long id;
  private String subject;
  private String content;
  private String subCategory;
  private Date created;
  private Date updated;

  private ErrorMessageDTO errorMessage;

  public TicketResponseDTO() {
  }

  public TicketResponseDTO(Long id) {
    super();
    this.status = OK_STATUS;
    this.id = id;
  }

  public TicketResponseDTO(ErrorMessageDTO errorMessage) {
    super();
    this.status = KO_STATUS;
    this.errorMessage = errorMessage;
  }
}
