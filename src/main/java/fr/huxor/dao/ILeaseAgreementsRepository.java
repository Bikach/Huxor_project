package fr.huxor.dao;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.LeaseAgreements;

public interface ILeaseAgreementsRepository extends JpaRepository<LeaseAgreements, String>{
	
//	@Query("")
//	public Page<Map<String, String>> carListAvailable(@Param("pickupDate") Date pickupDate,
//			@Param("dropDate") Date dropDate, Pageable pageable);

}
