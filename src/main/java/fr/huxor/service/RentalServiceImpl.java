package fr.huxor.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.huxor.HuxorProject1Application;
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
import fr.huxor.util.CarsCategorys;

@Service
@Transactional
public class RentalServiceImpl implements IRentalService {

	@Autowired
	private ICarsRepository carsRepo;
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;
	@Autowired
	private IFeaturesRepository featuresRepo;
	@Autowired
	private IUsersService userService;

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
	public void bookACar(String username, String licencePlate, String pickupDate, String dropDate)
			throws CustomException {
		Customers user = (Customers) userService.findAUser(username);
		Cars car = findACar(licencePlate);
		double totalPrice = totalPrice(pickupDate, dropDate, car.getDailyPrice());
		try {
			leaseRepo.save(new LeaseAgreements(null, HuxorProject1Application.DATE_FORMAT.parse(pickupDate),
					HuxorProject1Application.DATE_FORMAT.parse(dropDate), car.getKmNumber(), 0, user, car, totalPrice));
		} catch (ParseException e) {
			throw new CustomException("Le format de la date est incorect");
		}
	}

	// ===== Manager ===== //

	/**
	 * Add a car to the BDD
	 * 
	 * @param car     attributes
	 * @param feature attributes
	 * @throws Custom Exeption
	 */
	@Override
	public void addACar(String licencePlate, int kmNumber, CarsCategorys category, double dailyPrice, float kmPrice,
			byte carDoor, byte seatingCapacity, byte power, String color, String transmission, String fuel,
			Brands brand, Models model) throws CustomException {

		if (!carsRepo.existsById(licencePlate)) {

			Cars car = new Cars(licencePlate, kmNumber, category, dailyPrice, kmPrice);

			Features feature = new Features(carDoor, seatingCapacity, power, color, transmission, fuel, brand, model);

			featuresRepo.saveAndFlush(feature);
			car.setFeature(feature);
			carsRepo.save(car);

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

	/**
	 * 
	 * Update daily price
	 * 
	 * @param licencePlate
	 * @param dalilyPrice
	 */
	@Override
	public void updateDailyPriceCar(String licencePlate, double dailyPrice) throws CustomException {
		Cars car = findACar(licencePlate);
		car.setDailyPrice(dailyPrice);
		carsRepo.save(car);
	}

	/**
	 * Update km
	 * 
	 * @param licencePlate
	 * @param numbre       km
	 */
	@Override
	public void updateKmCar(String licencePlate, int nbkm) throws CustomException {
		Cars car = findACar(licencePlate);
		car.setKmNumber(nbkm);
		carsRepo.save(car);
	}

	// ===== Manager/Customer/admin =====//

	/**
	 * Return available vehicles on more than one page
	 * 
	 * @param pickup
	 * @param drop
	 * @param page
	 * @param size
	 */
//	@Override
//	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size) {
//		return carsRepo.carListAvailable(pickup, drop, PageRequest.of(page, size));
//	}

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
	private Features avoidsDuplicatingFeatures(Features feature) {
		Example<Features> example = Example.of(feature);
		
		if (!featuresRepo.exists(example)) 
			return feature;

		Optional<Features> featOpt = featuresRepo.findOne(example);
		Features feat = featOpt.get();
		
		return feat;
	}

}
