package fr.huxor;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.huxor.entities.Addresses;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Models;
import fr.huxor.service.IRentalService;
import fr.huxor.service.IUsersService;
import fr.huxor.util.CarsCategorys;

@SpringBootApplication
public class HuxorProject1Application implements CommandLineRunner {

	@Autowired
	private IRentalService rentalService;
	@Autowired
	private IUsersService usersService;

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		SpringApplication.run(HuxorProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Managers test
		usersService.addManager("Man1", "man1@email.com", "1234", "Jean", "Dupont", true, "273827EDZ");
		usersService.addManager("Man2", "man2@email.com", "1234", "Eric", "Lapierre", true, "278727KJH");

		// Customers test
		usersService.addCustomer("Use1", "use1@email.com", "1234", "Bruce", "Wayne", true,
				DATE_FORMAT.parse("1980-09-16"), "2378736483",
				new Addresses("4 avenue Dausmenil", "Paris", "75012"));
		usersService.addCustomer("Use2", "use2@email.com", "1234", "Brad", "Pit", false,
				DATE_FORMAT.parse("1977-10-06"), "2808738947",
				new Addresses("3 rue Victor Hugo", "Bondy", "93300"));
		usersService.addCustomer("Use3", "use3@email.com", "1234", "Pamela", "Anderson", true,
				DATE_FORMAT.parse("1968-03-20"), "9382473347",
				new Addresses("342 rue malibu", "Montrouge", "92100"));

		// Cars test
		rentalService.addACar("immat 1", 12500, CarsCategorys.BERLINE, 70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "bleu",
				"automatique", "gazol", new Brands("BMW"), new Models("SERIE 5"));
		rentalService.addACar("immat 2", 14070, CarsCategorys.CITADINE, 50d, 1f, (byte) 5, (byte) 5, (byte) 6,
				"blanche", "manuelle", "essence", new Brands("CITROEN"), new Models("C4"));
		rentalService.addACar("immat 3", 22500, CarsCategorys.CITADINE, 50d, 1f, (byte) 3, (byte) 5, (byte) 6, "rouge",
				"manuelle", "gazol", new Brands("PEUGOET"), new Models("308"));
		rentalService.addACar("immat 4", 8900, CarsCategorys.COMPACT, 35d, 0.8f, (byte) 2, (byte) 4, (byte) 5, "jaune",
				"manuelle", "essence", new Brands("FIAT"), new Models("500"));
		rentalService.addACar("immat 5", 32500, CarsCategorys.FAMILLIALE, 60d, 1.2f, (byte) 5, (byte) 6, (byte) 6,
				"vert", "automatique", "gazol", new Brands("FORD"), new Models("CMAX"));
		rentalService.addACar("immat 6", 8900, CarsCategorys.LUXE, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
				"automatique", "gazol", new Brands("MERCEDES"), new Models("CLASSE S"));

		// LeaseAgreements, checkCars test

		// Messages & Newsletters test

		// Permet d'afficher a la console les voitures libre entre deux date passé en
		// parametre
//		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		ArrayList<Map<String, String>> objects = carsRepo.carListAvailable( dateFormat.parse("2018-09-04"),  dateFormat.parse("2018-09-18"));
//		objects.forEach(object->System.out.println(object));

	}

//	public void addACar(String licencePlate, int kmNumber, CarsCategorys category, double dailyPrice, float kmPrice,
//			byte carDoor, byte seatingCapacity, byte power, String color, String transmission, String fuel,
//			Brands brand, Models model) throws CustomException {
//
//		if (!carsRepo.existsById(licencePlate)) {
//
//			Cars car = new Cars(licencePlate, kmNumber, category, dailyPrice, kmPrice);
//			Features feature = new Features(carDoor, seatingCapacity, power, color, transmission, fuel, brand, model);
//
//			featureRepo.save(feature);
//			car.setFeature(feature);
//			carsRepo.save(car);
//
//		} else {
//			throw new CustomException("Le véhicule " + licencePlate + " est déja enregistré");
//		}
//	}
}
