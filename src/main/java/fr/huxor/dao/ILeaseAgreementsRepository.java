package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.LeaseAgreements;

public interface ILeaseAgreementsRepository extends JpaRepository<LeaseAgreements, String>{

}
