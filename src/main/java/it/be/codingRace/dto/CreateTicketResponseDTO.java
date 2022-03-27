package it.be.codingRace.dto;

import it.be.codingRace.exception.ErrorMessageDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTicketResponseDTO {
  public static final String OK_STATUS = "OK";
  public static final String KO_STATUS = "KO";

  private String status;
  private Long ticketId;

  private ErrorMessageDTO errorMessage;

  public CreateTicketResponseDTO(Long ticketId) {
    super();
    this.status = OK_STATUS;
    this.ticketId = ticketId;
  }

  public CreateTicketResponseDTO(ErrorMessageDTO errorMessage) {
    super();
    this.status = KO_STATUS;
    this.errorMessage = errorMessage;
  }
}
