package it.be.codingRace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "ATTACHMENT")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTACHMENT_SEQ")
  @SequenceGenerator(name = "ATTACHMENT_SEQ", allocationSize = 1)
  private Long id;

  private String fileName;

  private String contentType;

  private long size;

  @Lob private byte[] body;

  private Date created;

  private Date updated;
}
