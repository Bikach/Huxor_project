package fr.huxor.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.LeaseAgreements;

public interface ILeaseAgreementsRepository extends JpaRepository<LeaseAgreements, Long> {

	/**
	 * Recovers a leaseAgreement thanks to its number
	 *
	 * @param numerAgreement
	 * @return LeaseAgreements
	 */
	@Query("SELECT l FROM LeaseAgreements l where l.numberAgreement  = :number")
	public Optional<LeaseAgreements> findByNumberAgreement(@Param("number") String numberAgreement);

	/**
	 * allows you to retrieve rental contracts that have the agreement number field
	 * null or not to a customer
	 * 
	 * @param pageable
	 * @return leaseAgreements with number null or not null
	 */
	@Query("SELECT l FROM LeaseAgreements l where l.numberAgreement IS :nullOrNotNull and l.customer.username = :user")
	public Page<LeaseAgreements> leaseAgreementNullPage(@Param("nullOrNotNull") String status,
			@Param("user") String customer, Pageable pageable);

	/**
	 * Find a leaseAgreements by username
	 * 
	 * @param user
	 * @param pageable
	 * @return leaseAgreements by user
	 */
	@Query("SELECT l FROM LeaseAgreements l where l.customer.username = :user")
	public Page<LeaseAgreements> leaseAgreementFromUser(@Param("user") String user, Pageable pageable);
}
