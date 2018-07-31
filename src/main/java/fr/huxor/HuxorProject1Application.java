package fr.huxor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.init.CannotReadScriptException;

import fr.huxor.dao.CarsRepository;
import fr.huxor.dao.UsersRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Features;
import fr.huxor.entities.Managers;
import fr.huxor.entities.Models;
import fr.huxor.entities.Users;

@SpringBootApplication
public class HuxorProject1Application implements CommandLineRunner {

	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private CarsRepository carsRepo;

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
				new Date("04/10/ 1980"), "238784678263872",
				new Addresses("2 rue du lion", "Paris", "75012")));
		Users us4 = usersRepo.save(new Customers("sonicboum@gmail.com", "son78", "Sonic", "boum",false,
				new Date("14/03/ 1990"), "987678952678287",
				new Addresses("5 avenue Dausmenil", "Gagny", "93000")));
		
		//Cars test
		Cars ca1 = carsRepo.save(new Cars("BN-268-KH", 25000,
				new Features((byte)5,(byte)5, (byte)4, "blue", "manual", "gazol", "citadine", new Models("Fiesta"), new Brands("Ford"))));
		
		//LeaseAgreements, checkCars test
	}
}
