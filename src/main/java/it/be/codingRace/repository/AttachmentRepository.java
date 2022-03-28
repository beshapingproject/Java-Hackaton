package it.be.codingRace.repository;

import org.springframework.stereotype.Repository;

import it.be.codingRace.entity.AttachmentEntity;

import java.util.List;

@Repository
public interface AttachmentRepository extends GenericRepository<AttachmentEntity, Long> {

    List<AttachmentEntity> findByIdIn(List<Long> attachmentIds);
}
