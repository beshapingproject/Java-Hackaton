package it.be.codingRace.repository;

import org.springframework.stereotype.Repository;

import it.be.codingRace.entity.AttachmentEntity;

@Repository
public interface AttachmentRepository extends GenericRepository<AttachmentEntity, Long> {}
