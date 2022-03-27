package it.be.codingRace.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentDTO {

  private Long id;

  @NotEmpty(message = "fileName must not be empty")
  private String fileName;

  @NotEmpty(message = "contentType must not be empty")
  private String contentType;

  private long size;

  @NotEmpty(message = "body must not be empty")
  private byte[] body;

  public AttachmentDTO(String fileName, String contentType, long size, byte[] body) {
    super();
    this.fileName = fileName;
    this.contentType = contentType;
    this.size = size;
    this.body = body;
  }
}
