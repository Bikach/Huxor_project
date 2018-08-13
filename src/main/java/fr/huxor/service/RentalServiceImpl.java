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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.huxor.dao.ICarsRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.LeaseAgreements;

@Service
@Transactional
public class RentalServiceImpl implements IRentalService {

	@Autowired
	private ICarsRepository carsRepo;
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;
	@Autowired
	private IUsersService userService;

	ServiceUtility service;

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

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
		double totalPrice = totalPriceWithoutKm(pickupDate, dropDate, car.getDailyPrice());
		System.out.println("total");
		try {
			leaseRepo.save(new LeaseAgreements(null, DATE_FORMAT.parse(pickupDate), DATE_FORMAT.parse(dropDate),
					car.getKmNumber(), 0, user, car, totalPrice));
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
	public void addACar(String licencePlate, int kmNumber, double dailyPrice, float kmPrice, byte carDoor,
			byte seatingCapacity, byte power, String color, String transmission, String fuel, String category,
			String brand, String model) throws CustomException {

		if (!carsRepo.existsById(licencePlate)) {

			Cars car = new Cars(licencePlate, kmNumber, dailyPrice, kmPrice, carDoor, seatingCapacity, power, color,
					transmission, fuel);
			car.setCategory(service.checkAllCategorys(category));
			car.setBrand(service.checkAllBrands(brand));
			car.setModel(service.checkAllModels(model));

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
	@Override
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size) {
		return carsRepo.carListAvailable(pickup, drop, PageRequest.of(page, size));
	}

	// ========private function===========//

	/**
	 * Calculate the total price of a reservation
	 * 
	 * @param pickup
	 * @param drop
	 * @param dailyPrice
	 * @return the total rental price
	 */
	private double totalPriceWithoutKm(String pickup, String drop, double dailyPrice) {
		double Days = nbDaysRent(pickup, drop);
		return Days * dailyPrice;
	}

	/**
	 * calculates the number of days between two dates
	 * 
	 * @param pickup
	 * @param drop
	 * @return number of days to rent
	 */
	protected int nbDaysRent(String pickup, String drop) {
		LocalDate startDate = LocalDate.parse(pickup);
		LocalDate endDate = LocalDate.parse(drop);
		return (int) ChronoUnit.DAYS.between(startDate, endDate);
	}

}
