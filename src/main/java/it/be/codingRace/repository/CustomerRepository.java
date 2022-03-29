package it.be.codingRace.repository;

import org.springframework.stereotype.Repository;

import it.be.codingRace.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends GenericRepository<CustomerEntity, Long> {}
