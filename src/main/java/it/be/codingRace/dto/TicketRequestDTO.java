package it.be.codingRace.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequestDTO implements Serializable {
  /** */
  private static final long serialVersionUID = 832598692666554292L;

  @NotEmpty(message = "subject must not be empty")
  private String subject;

  @NotEmpty(message = "content must not be empty")
  private String content;

  @NotEmpty(message = "content must not be empty")
  private String subCategory;

  private List<Long> attachmentIds;

  private String status;

  private Long id;

}
