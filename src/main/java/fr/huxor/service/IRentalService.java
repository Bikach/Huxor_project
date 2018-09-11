package fr.huxor.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;

public interface IRentalService {

	// Customer
	public void bookACar(String username, String idCar, String startDate, String endDate)
			throws CustomException, ParseException;

	// Manager
	public void addACar(String licencePlate, String picturePath, int kmNumber, double dailyPrice, float kmPrice,
			byte carDoor, byte seatingCapacity, byte power, String color, String transmission, String fuel,
			String category, String brand, String model) throws CustomException;

	public void deleteACar(String licensePlate) throws CustomException;

	public Cars findACar(String licensePlate) throws CustomException;
	
	public void updateKmCar(String licencePlate, int nbkm) throws CustomException;

	public void updateDailyPriceCar(String licencePlate, double dailyPrice) throws CustomException;
	
	// Customer/Manager
	public Page<Cars> carListAvailable(LocalDate start, LocalDate end, int page, int size)
			throws CustomException;

}
