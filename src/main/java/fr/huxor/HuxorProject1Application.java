package fr.huxor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.huxor.dao.ICarsRepository;
import fr.huxor.dao.ICheckCarsRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.dao.IMessagesRepository;
import fr.huxor.dao.INewslettersRepository;
import fr.huxor.dao.IUsersRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Cars;
import fr.huxor.entities.CheckCars;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Features;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.entities.Managers;
import fr.huxor.entities.Messages;
import fr.huxor.entities.Models;
import fr.huxor.entities.Newsletters;
import fr.huxor.entities.Users;
import fr.huxor.service.IRentalService;
import fr.huxor.service.RentalServiceImpl;

@SpringBootApplication
public class HuxorProject1Application implements CommandLineRunner {

	@Autowired
	private IUsersRepository usersRepo;
	@Autowired
	private ICarsRepository carsRepo;
	@Autowired
	private ILeaseAgreementsRepository agreementsRepo;
	@Autowired
	private ICheckCarsRepository checkCarsRepo;
	@Autowired
	private IMessagesRepository messagesRepo;
	@Autowired
	private INewslettersRepository newslettersRepo;

	public static void main(String[] args) {
		SpringApplication.run(HuxorProject1Application.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {

		// Managers test
//		Users us1 = usersRepo.save(new Managers("sangoku@gmail.com", "san12", "San", "Goku", true, "abc123"));
//		Users us2 = usersRepo.save(new Managers("peterparker@gmail.com", "par34", "Parker", "Peter", true, "def456"));
//		Users us3 = usersRepo.save(new Managers("peterpan@gmail.com", "pan56", "Pan", "Pan", true, "ghi789"));

		// Customers test
//		Users us4 = usersRepo.save(new Customers("clarkkent@gmail.com", "ken56", "Kent", "Clark", true,
//				new Date("04/10/1980"), "238784678263872", new Addresses("2 rue du lion", "Paris", "75012")));
//		Users us5 = usersRepo.save(new Customers("sonicboum@gmail.com", "bou78", "Sonic", "Boum", true,
//				new Date("14/03/1990"), "987678952678287", new Addresses("5 avenue Dausmenil", "Gagny", "93220")));
//		Users us6 = usersRepo.save(new Customers("georgeclooney@gmail.com", "cloo90", "Clooney", "George", true,
//				new Date("12/07/1962"), "726349873049382", new Addresses("8 rue du barrage", "Viry-Chatillon", "91170")));
//		Users us7 = usersRepo.save(new Customers("adrianakarembeu@gmail.com", "kar12", "Karembeu", "Adriana", true,
//				new Date("25/05/1965"), "736492039486548", new Addresses("29 rue de l'amiral", "Marseille", "13003")));
//		Users us8 = usersRepo.save(new Customers("georgebush@gmail.com", "bus34", "Bush", "George", true,
//				new Date("22/10/1987"), "120637483905462", new Addresses("234 avenue washington", "Montrouge", "92120")));
//		Users us9 = usersRepo.save(new Customers("angelinajolie@gmail.com", "jol56", "Jolie", "Angelina", false,
//				new Date("08/02/1970"), "429846374629304", new Addresses("34 square picpus", "Paris", "75012")));

		// Cars test
//		Cars ca1 = carsRepo.save(new Cars("BN-268-KH", 25000, 50d,  new Features((byte) 5, (byte) 5, (byte) 4, "blue",
//				"manual", "essence", "citadine", new Models("Fiesta"), new Brands("Ford"))));
//		Cars ca2 = carsRepo.save(new Cars("KL-228-MH", 17000, 50d,  new Features((byte) 3, (byte) 5, (byte) 4, "red",
//				"manual", "essence", "citadine", new Models("Corsa"), new Brands("Opel"))));
//		Cars ca3 = carsRepo.save(new Cars("JN-138-LK", 12500, 70d,  new Features((byte) 3, (byte) 8, (byte) 6, "black",
//				"automatique", "gazol", "familiale", new Models("classe V"), new Brands("Mercedes"))));
//		Cars ca4 = carsRepo.save(new Cars("ML-432-MH", 22800, 100d,  new Features((byte) 5, (byte) 5, (byte) 7, "black",
//				"automatique", "gazol", "luxe", new Models("serie 5"), new Brands("BMW"))));
		
		// LeaseAgreements, checkCars test
//		LeaseAgreements la1 = agreementsRepo.save(new LeaseAgreements("jueidl12876", new Date("08/05/2018"),
//				new Date("08/15/2018"), false, (Customers) us4, ca1, 500d));
//		CheckCars cc1 = checkCarsRepo.save(new CheckCars("678567HJHJH", "clean", null, "clean", null, "clean", null,
//				"clean", null, ca1, (Managers) us1, la1));
//		LeaseAgreements la2 = agreementsRepo.save(new LeaseAgreements("kdhjis6766", new Date("09/10/2018"),
//				new Date("09/25/2018"), false, (Customers) us5, ca2, 750d));
//		CheckCars cc2 = checkCarsRepo.save(new CheckCars("67DS3232FDH", "pte passa ray prof", null, "clean", null,
//				"clean", null, "clean", null, ca2, (Managers) us2, la2));
//		LeaseAgreements la3 = agreementsRepo.save(new LeaseAgreements("sldo829", new Date("11/02/2018"),
//				new Date("12/25/2018"), false, (Customers) us8, ca4, 5500d));
//		CheckCars cc3 = checkCarsRepo.save(new CheckCars("3242DI2242EE", "clean", null, "clean", null,
//				"clean", null, "clean", null, ca4, (Managers) us2, la3));
//		LeaseAgreements la4 = agreementsRepo.save(new LeaseAgreements("sjkidso89", new Date("09/05/2018"),
//				new Date("09/17/2018"), false, (Customers) us6, ca3, 600d));
//		CheckCars cc4 = checkCarsRepo.save(new CheckCars("874873JHZU23", "clean", null, "clean", null,
//				"clean", null, "clean", null, ca3, (Managers) us1, la4));

		// Messages & Newsletters test
//		Messages me1 = messagesRepo.save(new Messages("Wayne", "Bruce", "brucewayne@gmail.com",
//				"J'aimerais louer une nouvelle batmobile, est ce possible ?"));
//		Messages me2 = messagesRepo.save(new Messages("Brad", "Pitt", "bradpitt@gmail.com",
//				"J'ai besoin d'un helicoptère pour mon prochain film, avez vous ça en stock  ?"));
//		Newsletters nl1 = newslettersRepo.save(new Newsletters("emmanuelmacron@gmail.com"));
//		Newsletters nl2 = newslettersRepo.save(new Newsletters("jacqueschirac@gmail.com"));

		// Permet d'afficher a la console les voitures libre entre deux date passé en parametre
//		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		ArrayList<Map<String, String>> objects = carsRepo.carListAvailable( dateFormat.parse("2018-09-04"),  dateFormat.parse("2018-09-18"));
//		objects.forEach(object->System.out.println(object));
		
		
		// IRentalService test
//		RentalServiceImpl rental = new RentalServiceImpl();
//		long price = rental.totalPrice("2018-08-05", "2018-08-15", 50);
//		System.out.println(price);
		
//		Cars c = rental.searchACar("KL-228-MH");
//		System.out.println(c.getLicencePlate());
	}
}
