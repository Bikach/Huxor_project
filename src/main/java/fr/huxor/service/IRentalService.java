package fr.huxor.service;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.util.CarBrand;
import fr.huxor.util.CarsCategorys;

public interface IRentalService {

	// Customer
	public void bookACar(long IdCustomer, String idCar, String pickupDate, String dropDate, int startKm) throws CustomException;

	// Manager
	public void addACar(String licencePlate, int kmNumber, CarsCategorys category, double dailyPrice, byte kmPrice,
			CarBrand brand, byte carDoor, byte seatingCapacity, byte power, String color, String transmission,
			String fuel, String modelName, String brandName) throws CustomException;

	public void deleteACar(String licensePlate) throws CustomException;

	public Cars findACar(String licensePlate) throws CustomException;

	public void updateKmCar(String licencePlate, int nbkm) throws CustomException;

	public void updateDailyPriceCar(String licencePlate, double dailyPrice) throws CustomException;

	// Customer/Manager
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size)
			throws CustomException;

}
