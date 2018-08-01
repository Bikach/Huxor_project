package fr.huxor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.huxor.dao.CarsRepository;
import fr.huxor.dao.CheckCarsRepository;
import fr.huxor.dao.LeaseAgreementsRepository;
import fr.huxor.dao.UsersRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.CheckCars;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Features;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.entities.Managers;
import fr.huxor.entities.Models;
import fr.huxor.entities.Users;

@SpringBootApplication
public class HuxorProject1Application implements CommandLineRunner {

	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private CarsRepository carsRepo;
	@Autowired
	private LeaseAgreementsRepository agreementsRepo;
	@Autowired
	private CheckCarsRepository checkCarsRepo;

	public static void main(String[] args) {
		SpringApplication.run(HuxorProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Managers test
		Users us1 = usersRepo.save(new Managers("dupontjean@gmail.com", "dup12", "Dupont", "jean", true, "abc123"));
		Users us2 = usersRepo.save(new Managers("castlepierre@gmail.com", "cas34", "Castle", "Pierre", true, "def456"));

		// Customers test
		Users us3 = usersRepo.save(new Customers("beauvaisjack@gmail.com", "bea56", "Beauvai", "alain", true,
				new Date("04/10/ 1980"), "238784678263872", new Addresses("2 rue du lion", "Paris", "75012")));
		Users us4 = usersRepo.save(new Customers("sonicboum@gmail.com", "son78", "Sonic", "boum", false,
				new Date("14/03/ 1990"), "987678952678287", new Addresses("5 avenue Dausmenil", "Gagny", "93000")));

		// Cars test
		Cars ca1 = carsRepo.save(new Cars("BN-268-KH", 25000, new Features((byte) 5, (byte) 5, (byte) 4, "blue",
				"manual", "gazol", "citadine", new Models("Fiesta"), new Brands("Ford"))));
		Cars ca2 = carsRepo.save(new Cars("KL-228-MH", 17000, new Features((byte) 3, (byte) 4, (byte) 4, "red",
				"manual", "essence", "citadine", new Models("Corsa"), new Brands("Opel"))));

		// LeaseAgreements, checkCars test
		LeaseAgreements la1 = agreementsRepo.save(new LeaseAgreements("jueidl12876", new Date("08/02/2018"),
				new Date("08/12/2018"), false, (Customers) us3, ca1, 500d));
		CheckCars cc1 = checkCarsRepo.save(new CheckCars("678567HJHJH", "clean", null, "clean",
				null, "clean", null, "clean", null, ca1, (Managers) us1, la1));
		LeaseAgreements la2 = agreementsRepo.save(new LeaseAgreements("kdhjis6766", new Date("09/10/2018"),
				new Date("09/25/2018"), false, (Customers) us4, ca2, 750d));
		CheckCars cc2 = checkCarsRepo.save(new CheckCars("67DS3232FDH", "pte passa ray prof", null, "clean",
				null, "clean", null, "clean", null, ca2, (Managers) us2, la2));
		
		

	}
}
