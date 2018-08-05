package fr.huxor.service;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;

public interface IRentalService {

	// Customer
	public void bookACar(Customers customer, String licensePlate) throws CustomException;

	// Manager
	public void addACar(String licencePlate, int kmNumber, double dailyPrice, byte carDoor, byte seatingCapacity,
			byte power, String color, String transmission, String fuel, String typeCar,String modelName,
				String brandName) throws CustomException;
	public void deleteACar(String licensePlate) throws CustomException;
	public Cars searchACar(String licensePlate) throws CustomException;

	// Customer/Manager
	public Page<Map<String, String>> carListAvailable(Date pickup, Date drop, int page, int size) throws CustomException;

}
