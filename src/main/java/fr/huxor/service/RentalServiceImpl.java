package fr.huxor.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.huxor.dao.IBrandsRepository;
import fr.huxor.dao.ICarsRepository;
import fr.huxor.dao.ICategorysRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.dao.IModelsRepository;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.Categorys;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.entities.Models;

@Service 
@Transactional
public class RentalServiceImpl implements IRentalService {

	@Autowired
	private ICarsRepository carsRepo;
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;
	@Autowired
	private IUsersService userService;
	@Autowired
	private IModelsRepository modelRepo;
	@Autowired
	private IBrandsRepository brandRepo;
	@Autowired
	private ICategorysRepository categoryRepo;

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	// ===== Customer ===== //

	/**
	 * Customer book a car
	 * 
	 * @param idCustomer
	 * @param licencePlate
	 * @param pickupDate
	 * @paramdropDate
	 * @throws Custom Exeption
	 */
	@Override
	public void bookACar(String username, String licencePlate, String startDate, String endDate)
			throws CustomException {
		Customers user = (Customers) userService.findAUser(username);
		Cars car = findACar(licencePlate);
		double totalPrice = totalPriceWithoutKm(startDate, endDate, Double.toString(car.getDailyPrice()));

		leaseRepo.save(new LeaseAgreements(null, LocalDate.parse(startDate), LocalDate.parse(endDate),
				car.getKmNumber(), 0, user, car, totalPrice));

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
	public void addACar(String licencePlate, String picturePath, int kmNumber, double dailyPrice, float kmPrice, byte carDoor,
			byte seatingCapacity, byte power, String color, String transmission, String fuel, String category,
			String brand, String model) throws CustomException {

		if (!carsRepo.existsById(licencePlate)) {

			Cars car = new Cars(licencePlate, picturePath,  kmNumber, dailyPrice, kmPrice, carDoor, seatingCapacity, power, color,
					transmission, fuel);
			car.setCategory(checkAllCategorys(category));
			car.setBrand(checkAllBrands(brand));
			car.setModel(checkAllModels(model));

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
	public Page<Cars> carListAvailable(LocalDate start, LocalDate end, int page, int size) {
		return carsRepo.carListAvailable(start, end, PageRequest.of(page, size));
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
	public double totalPriceWithoutKm(String startDate, String endDate, String dailyPrice) {
		double Days = nbDaysRent(startDate, endDate);
		return Days * Double.parseDouble(dailyPrice);
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
	
	/**
	 * avoid duplicating Models
	 * 
	 * @param modelName
	 * @return an existing Model or a new one
	 */
	private Models checkAllModels(String modelName) {

		if (modelRepo.existsById(modelName)) {
			Optional<Models> mod = modelRepo.findById(modelName);
			Models m = mod.get();
			return m;
		} else {
			Models m = new Models(modelName);
			modelRepo.saveAndFlush(m);
			return m;
		}
	}

	/**
	 * avoid duplicating Brands
	 * 
	 * @param brandName
	 * @return an existing Brand or a new one
	 */
	private Brands checkAllBrands(String brandName) {

		if (brandRepo.existsById(brandName)) {
			Optional<Brands> bra = brandRepo.findById(brandName);
			Brands b = bra.get();
			return b;
		} else {
			Brands b = new Brands(brandName);
			brandRepo.saveAndFlush(b);
			return b;
		}
	}

	/**
	 * avoid duplicating Categorys
	 * 
	 * @param categoryName
	 * @return an existing Category or a new one
	 */
	private Categorys checkAllCategorys(String categoryName) {

		if (categoryRepo.existsById(categoryName)) {
			Optional<Categorys> cat = categoryRepo.findById(categoryName);
			Categorys c = cat.get();
			return c;
		} else {
			Categorys c = new Categorys(categoryName);
			categoryRepo.saveAndFlush(c);
			return c;
		}
	}

}
