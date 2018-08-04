package fr.huxor.service;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Cars;
import fr.huxor.entities.Customers;

public interface IRentalService {

	// Customer
	public void bookACar(Customers customer, String licensePlate);

	// Manager
	public void addACar(String licencePlate, int kmNumber, double dailyPrice, byte carDoor, byte seatingCapacity,
			byte power, String color, String transmission, String fuel, String typeCar, String brandName,
			String modelName);
	public void deleteACar(String licensePlate);
	public Cars searchACar(String licensePlate);

	// Customer/Manager
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size);

}
