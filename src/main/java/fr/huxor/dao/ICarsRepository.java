package fr.huxor.dao;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.Cars; 

public interface ICarsRepository extends JpaRepository<Cars, String> {

	/**
	 * Allows you to retrieve a map of available cars between two dates in pageable object
	 * @param startDate
	 * @param comebackDate
	 * @param pageable
	 * @return ArrayLIst<Map<String, String>>
	 */
	@Query(value="SELECT new map("
			+ "c.licencePlate as licencePlate, c.dailyPrice as Price, c.carCategory, f.carDoor as Door, "
			+ "f.color as color, f.fuel as fuel, f.power as power, f.seatingCapacity as seat, f.transmission as transmission, "
			+ "f.carBrand as brand, f.model.modelName as model) "
			+ "FROM Cars c "
			+ "INNER JOIN Features f ON c.feature= f.idFeature "
			+ "WHERE c.licencePlate NOT IN "
			+ "( SELECT l.car  "
			+ "FROM LeaseAgreements l "
			+ "WHERE :pickupDate BETWEEN l.startDate AND l.comebackDate "
			+ "OR :dropDate BETWEEN l.startDate AND l.comebackDate "
			+ "OR l.startDate BETWEEN :pickupDate AND :dropDate )")
	public Page<Map<String, String >> carListAvailable(@Param("pickupDate") Date pickupDate, @Param("dropDate")Date dropDate, Pageable pageable);

}
