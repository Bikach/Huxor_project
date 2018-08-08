package fr.huxor.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.huxor.dao.ICarsRepository;
import fr.huxor.dao.IFeaturesRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Features;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.entities.Models;

public class RentalServiceImpl implements IRentalService {

	@Autowired
	private ICarsRepository carsRepo;
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;

	@Autowired
	private IUsersService userService;

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// ===== Customer ===== //

	/**
	 * 
	 * Customer book a car
	 * 
	 * @param idCustomer 
	 * @param licencePlate
	 * @param pickupDate 
	 * @paramdropDate 
	 * @throws Custom Exeption
	 */
	@Override
	public void bookACar(long idCustomer, String licencePlate, String pickupDate, String dropDate)
			throws CustomException {
		Customers user = (Customers) userService.findAUser(idCustomer);
		Cars car = findACar(licencePlate);
		double totalPrice = totalPrice(pickupDate, dropDate, car.getDailyPrice());
		try {
			leaseRepo.save(new LeaseAgreements(null, dateFormat.parse(pickupDate), dateFormat.parse(dropDate), user,
					car, totalPrice));
		} catch (ParseException e) {
			throw new CustomException("Le format de la date est incorect");
		}
	}

	// ===== Manager ===== //

	/**
	 * Add a car to the BDD
	 * 
	 * @param car  attributes
	 * @param feature attributes
	 * @throws Custom Exeption
	 */
	@Override
	public void addACar(String licencePlate, int kmNumber, double dailyPrice, byte carDoor, byte seatingCapacity,
			byte power, String color, String transmission, String fuel, String typeCar, String modelName,
			String brandName) throws CustomException {
		// TODO verifier feature si il existe avant
		if (!carsRepo.existsById(licencePlate)) {
			carsRepo.save(new Cars(licencePlate, kmNumber, dailyPrice, new Features(carDoor, seatingCapacity, power,
					color, transmission, fuel, typeCar, new Models("modelName"), new Brands("brandName"))));
		} else {
			throw new CustomException("Le véhicule " + licencePlate + " est déja enregistré");
		}
	}

	@Override
	public void deleteACar(String licencePlate) {
		carsRepo.deleteById(licencePlate);
		// TODO à corriger delete cascade
	}

	/**
	 * Search car in database
	 * 
	 * @param licence plate
	 * @return a car
	 * @throws Custom Exeption
	 */
	@Override
	public Cars findACar(String licencePlate) throws CustomException {
		Optional<Cars> car = carsRepo.findById(licencePlate);
		if (car == null)
			throw new CustomException("Le véhicule " + licencePlate + " n'existe pas");
		Cars c = car.get();
		return c;
	}
	
	@Override
	public void updateCar(String licencePlate) throws CustomException {
		// TODO
	}

	// ===== Manager/Customer =====//

	/**
	 * Return available vehicles on more than one page
	 * 
	 * @param pickup
	 * @param drop
	 * @param page
	 * @param size
	 */
	@Override
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size) {
		return carsRepo.carListAvailable(pickup, drop, PageRequest.of(page, size));
	}

	// ===== class methode ===== //

	/**
	 * Calculate the total price of a reservation
	 * 
	 * @param pickup
	 * @param drop
	 * @param dailyPrice
	 * @return the total rental price
	 */
	private double totalPrice(String pickup, String drop, double dailyPrice) {
		LocalDate startDate = LocalDate.parse(pickup);
		LocalDate endDate = LocalDate.parse(drop);
		long Days = ChronoUnit.DAYS.between(startDate, endDate);
		return Days * dailyPrice;
	}

	/**
	 * check if feature already exists
	 * 
	 * @param features
	 * @return features that already exist or a new one
	 */
	private Features avoidsDuplicatingFeatures(Features features) {
		return new Features();
	}


}
