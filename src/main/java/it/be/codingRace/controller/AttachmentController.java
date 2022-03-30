package it.be.codingRace.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.be.codingRace.dto.AttachmentDTO;
import it.be.codingRace.exception.AttachmentException;
import it.be.codingRace.exception.AttachmentException.Type;
import it.be.codingRace.service.AttachmentService;
import it.be.codingRace.utils.JsonResponseBody;

@RestController
@RequestMapping("attachment")
public class AttachmentController {

  @Autowired private AttachmentService attachmentService;

  private AttachmentDTO fromPartToDto(MultipartFile file) throws AttachmentException {
    try {
      return new AttachmentDTO(
          file.getOriginalFilename(), file.getContentType(), file.getSize(), file.getBytes());
    } catch (IOException e) {
      throw new AttachmentException(
          e, "Error during deserialization of multipart", Type.INVALID_REQUEST);
    }
  }

  @PostMapping("/upload")
  @ApiOperation(value = "", notes = "UPLOAD FILE")
  public ResponseEntity<JsonResponseBody> uploadFile(
      @ApiParam(name = "file") @RequestPart(name = "file") MultipartFile file)
      throws AttachmentException {

    AttachmentDTO dto = fromPartToDto(file);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new JsonResponseBody(HttpStatus.OK.value(), attachmentService.uploadAttachment(dto)));
  }

  @GetMapping("/download/{attachmentId}")
  @ApiOperation(value = "", notes = "DOWNLOAD FILE")
  public ResponseEntity<byte[]> downloadFile(
      @ApiParam(name = "attachmentId") @PathVariable Long attachmentId) throws AttachmentException {

    AttachmentDTO attachment = attachmentService.getAttachment(attachmentId);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(attachment.getContentType()));
    String filename = attachment.getFileName();
    ContentDisposition contentDisposition =
        ContentDisposition.attachment().filename(filename).build();
    headers.setContentDisposition(contentDisposition);
    ResponseEntity<byte[]> response =
        new ResponseEntity<>(attachment.getBody(), headers, HttpStatus.OK);
    return response;
  }
}
