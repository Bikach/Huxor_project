package fr.huxor.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.Cars;

public interface ICarsRepository extends JpaRepository<Cars, Long> {

	/**
	 * Allows you to retrieve the list of available cars between two dates
	 * @param startDate
	 * @param comebackDate
	 * @return ArrayLIst<Map<String, String>>
	 */
	@Query(value="SELECT new map("
			+ "c.idCar as id, c.dailyPrice as Price, f.carDoor as Door, "
			+ "f.color as color, f.fuel as fuel, f.power as power, f.seatingCapacity as seat, f.transmission as transmission, f.typeCar as type, "
			+ "b.brandName as brand, m.modelName as model) "
			+ "FROM Cars c "
			+ "INNER JOIN Features f ON c.feature= f.idFeature "
			+ "INNER JOIN Brands b ON f.brand = b.idBrand "
			+ "INNER JOIN Models m ON f.model = m.idModel "
			+ "WHERE c.idCar NOT IN "
			+ "( SELECT l.car  "
			+ "FROM LeaseAgreements l "
			+ "WHERE :pickupDate BETWEEN l.startDate AND l.comebackDate "
			+ "OR :dropDate BETWEEN l.startDate AND l.comebackDate "
			+ "OR l.startDate BETWEEN :pickupDate AND :dropDate )")
	public ArrayList<Map<String, String >> carListAvailable(@Param("pickupDate") Date pickupDate, @Param("dropDate")Date dropDate);

}
