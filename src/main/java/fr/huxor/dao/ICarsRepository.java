package fr.huxor.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.Cars;

public interface ICarsRepository extends JpaRepository<Cars, String> {

	/**
	 * Allows you to retrieve of available cars between two dates in pageable object
	 * 
	 * @param startDate
	 * @param comebackDate
	 * @param pageable
	 * @return Cars
	 */
	@Query(value = "SELECT c "
			+ "FROM Cars c "
			+ "WHERE c.licencePlate NOT IN " 
			+"( SELECT l.car  " 
			+ "FROM LeaseAgreements l "
			+ "WHERE :pickupDate BETWEEN l.startDate AND l.endDate "
			+ "OR :dropDate BETWEEN l.startDate AND l.endDate "
			+ "OR l.startDate BETWEEN :pickupDate AND :dropDate )"
			+ "ORDER BY c.dailyPrice ASC")
	public Page<Cars> carListAvailable(@Param("pickupDate") Date pickupDate,
			@Param("dropDate") Date dropDate, Pageable pageable);
	
	

}
