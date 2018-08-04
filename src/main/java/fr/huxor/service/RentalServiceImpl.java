package fr.huxor.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import fr.huxor.dao.ICarsRepository;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Features;
import fr.huxor.entities.Models;

public class RentalServiceImpl implements IRentalService {

	@Autowired
	ICarsRepository carsRepo;

	// ===== Customer ===== //

	@Override
	public void bookACar(Customers customer, String licensePlate) {

	}

	private long totalPrice(String pickup, String drop, long dailyPrice) {
		LocalDate startDate = LocalDate.parse(pickup);
		LocalDate endDate = LocalDate.parse(drop);
		long range = ChronoUnit.DAYS.between(startDate, endDate);

		return range * dailyPrice;
	}

	// ===== Manager ===== //

	@Override
	public void addACar(String licencePlate, int kmNumber, double dailyPrice, byte carDoor, byte seatingCapacity,
			byte power, String color, String transmission, String fuel, String typeCar, String brandName,
			String modelName) {

		carsRepo.save(new Cars(licencePlate, kmNumber, dailyPrice, new Features(carDoor, seatingCapacity, power, color,
				transmission, fuel, typeCar, new Models(modelName), new Brands(brandName))));
	}

	@Override
	public void deleteACar(String licensePlate) {
		carsRepo.deleteById(licensePlate);
	}

	@Override
	public Cars searchACar(String licensePlate) {
		Optional<Cars> car = carsRepo.findById(licensePlate);
		if (car == null)
			throw new RuntimeException("Véhicule introuvable");
		Cars c = car.get();
		return c;
	}

	// ===== Manager/Customer =====//

	@Override
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
