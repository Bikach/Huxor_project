package fr.huxor.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.huxor.dao.IBrandsRepository;
import fr.huxor.dao.ICarsRepository;
import fr.huxor.dao.IFeaturesRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.dao.IModelsRepository;
import fr.huxor.dao.IUsersRepository;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Features;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.entities.Models;
import fr.huxor.entities.Users;

public class RentalServiceImpl implements IRentalService {

	@Autowired
	private ICarsRepository carsRepo;
	@Autowired
	private IFeaturesRepository featureRepo;
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;

	@Autowired
	private IUsersService userService;

	// ===== Customer ===== //

	@Override
	public void bookACar(long idCustomer, String licencePlate, String pickupDate, String dropDate)
			throws CustomException {
		Customers user = (Customers)userService.findAUser(idCustomer);
		Cars car = findACar(licencePlate);
		double totalPrice = totalPrice(pickupDate, dropDate, car.getDailyPrice());
//		leaseRepo.save(new LeaseAgreements(null, pickupDate, dropDate, user, car, totalPrice));
		// TODO correction Date et cast user
	}

	// ===== Manager ===== //

	/**
	 * Add a car to the BDD
	 * 
	 * @param car     attributes
	 * @param feature attributes
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
	 */
	@Override
	public Cars findACar(String licencePlate) throws CustomException {
		Optional<Cars> car = carsRepo.findById(licencePlate);
		if (car == null)
			throw new CustomException("Le véhicule " + licencePlate + " n'existe pas");
		Cars c = car.get();
		return c;
	}

	// ===== Manager/Customer =====//

	@Override
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size) {
		return carsRepo.carListAvailable(pickup, drop, PageRequest.of(page, size));
	}

	// ===== class methode ===== //

	/**
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

}
