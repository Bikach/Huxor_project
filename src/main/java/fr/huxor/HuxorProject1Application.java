package fr.huxor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import fr.huxor.dao.IBrandsRepository;
import fr.huxor.dao.ICarsRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.dao.IModelsRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.Cars;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.entities.Messages;
import fr.huxor.service.IContactService;
import fr.huxor.service.ILeaseService;
import fr.huxor.service.IRentalService;
import fr.huxor.service.IUsersService;

@SpringBootApplication
public class HuxorProject1Application implements CommandLineRunner {

	@Autowired
	private IRentalService rentalService;
	@Autowired
	private IUsersService usersService;
	@Autowired
	private ILeaseService leaseService;
	@Autowired
	private IContactService contactService;
		
	public static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		SpringApplication.run(HuxorProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

	// Managers test
//		usersService.addManager("Man1", "man1@email.com", "1234", "Jean", "Dupont", true, "273827EDZ");
//		usersService.addManager("Man2", "man2@email.com", "1234", "Eric", "Lapierre", true, "278727KJH");
//
		// Customers test
//		usersService.addCustomer("Use1", "use1@email.com", "1234", "Bruce", "Wayne", true,
//				DATE.parse("1980-09-16"), "2378736483",
//				new Addresses("4 avenue Dausmenil", "Paris", "75012"));
//		usersService.addCustomer("Use2", "use2@email.com", "1234", "Brad", "Pit", false,
//				DATE.parse("1977-10-06"), "2808738947",
//				new Addresses("3 rue Victor Hugo", "Bondy", "93300"));
//		usersService.addCustomer("Use3", "use3@email.com", "1234", "Pamela", "Anderson", true,
//				DATE.parse("1968-03-20"), "9382473347",
//				new Addresses("342 rue malibu", "Montrouge", "92100"));
//
		// Cars test
//		rentalService.addACar("immat 1", 12500,  70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "bleu",
//				"automatique", "gazol", "BERLINE", "BMW", "SERIE 5");
//		rentalService.addACar("immat 2", 14070, 50d, 1f, (byte) 5, (byte) 5, (byte) 6,
//				"blanche", "manuelle", "essence", "COMPACT", "CITROEN", "C4");
//		rentalService.addACar("immat 3", 22500,  50d, 1f, (byte) 3, (byte) 5, (byte) 6, "rouge",
//				"manuelle", "gazol", "COMPACT", "PEUGEOT", "308");
//		rentalService.addACar("immat 4", 8900, 35d, 0.8f, (byte) 2, (byte) 4, (byte) 5, "jaune",
//				"manuelle", "essence", "CITADINE", "FIAT", "500");
//		rentalService.addACar("immat 5", 32500,  60d, 1.2f, (byte) 5, (byte) 6, (byte) 6,
//				"vert", "automatique", "gazol", "FAMILIALE", "FORD", "CMAX");
//		rentalService.addACar("immat 6", 8900, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
//				"automatique", "gazol", "LUXE", "MERCEDES", "CLASSE S");
//		rentalService.addACar("immat 7", 9400, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
//				"automatique", "gazol", "LUXE", "BMW","SERIE 7");
//		rentalService.addACar("immat 8", 21500, 70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "bleu",
//				"automatique", "gazol", "BERLINE","MERCEDES","CLASSE E");
//		rentalService.addACar("immat 9", 11340, 35d, 0.8f, (byte) 4, (byte) 5, (byte) 4, "jaune",
//				"manuelle", "essence", "CITADINE", "RENAULT", "TWINGO");
//		rentalService.addACar("immat 10", 25730, 60d, 1.2f, (byte) 5, (byte) 5, (byte) 6, "rouge",
//			"automatique", "gazol", "FAMILIALE", "PEUGEOT", "5008");
//		rentalService.addACar("assets/bmw-serie-5-blanc.png","immat 11", 2500,  70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "blanche",
//				"automatique", "gazol", "BERLINE", "BMW", "SERIE 5");
//		rentalService.addACar("immat 12", 14070, 50d, 1f, (byte) 5, (byte) 5, (byte) 6,
//				"noir", "manuelle", "essence", "COMPACT", "CITROEN", "C4");
//		rentalService.addACar("immat 13", 22500,  50d, 1f, (byte) 3, (byte) 5, (byte) 6, "rouge",
//				"manuelle", "gazol", "COMPACT", "PEUGEOT", "308");
//		rentalService.addACar("immat 14", 8900, 35d, 0.8f, (byte) 2, (byte) 4, (byte) 5, "jaune",
//				"manuelle", "essence", "CITADINE", "FIAT", "500");
//		rentalService.addACar("immat 15", 32500,  60d, 1.2f, (byte) 5, (byte) 6, (byte) 6,
//				"vert", "automatique", "gazol", "FAMILIALE", "FORD", "CMAX");
//		rentalService.addACar("immat 16", 8900, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
//				"automatique", "gazol", "LUXE", "MERCEDES", "CLASSE S");
//		rentalService.addACar("immat 17", 9400, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
//				"automatique", "gazol", "LUXE", "BMW","SERIE 7");
//		rentalService.addACar("immat 18", 21500, 70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "bleu",
//				"automatique", "gazol", "BERLINE","MERCEDES","CLASSE E");
//		rentalService.addACar("immat 19", 11340, 35d, 0.8f, (byte) 4, (byte) 5, (byte) 4, "jaune",
//				"manuelle", "essence", "CITADINE", "RENAULT", "TWINGO");
//		rentalService.addACar("immat 20", 25730, 60d, 1.2f, (byte) 5, (byte) 5, (byte) 6, "rouge",
//				"automatique", "gazol", "FAMILIALE", "PEUGEOT", "5008");
//		rentalService.addACar("immat 21", 12500,  70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "bleu",
//				"automatique", "gazol", "BERLINE", "BMW", "SERIE 5");
//		rentalService.addACar("immat 22", 14070, 50d, 1f, (byte) 5, (byte) 5, (byte) 6,
//				"blanche", "manuelle", "essence", "COMPACT", "CITROEN", "C4");
//		rentalService.addACar("immat 23", 22500,  50d, 1f, (byte) 3, (byte) 5, (byte) 6, "rouge",
//				"manuelle", "gazol", "COMPACT", "PEUGEOT", "308");
//		rentalService.addACar("immat 24", 8900, 35d, 0.8f, (byte) 2, (byte) 4, (byte) 5, "jaune",
//				"manuelle", "essence", "CITADINE", "FIAT", "500");
//		rentalService.addACar("immat 25", 32500,  60d, 1.2f, (byte) 5, (byte) 6, (byte) 6,
//				"vert", "automatique", "gazol", "FAMILIALE", "FORD", "CMAX");
//		rentalService.addACar("immat 26", 8900, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
//				"automatique", "gazol", "LUXE", "MERCEDES", "CLASSE S");
//		rentalService.addACar("immat 27", 9400, 100d, 2f, (byte) 5, (byte) 5, (byte) 8, "black",
//				"automatique", "gazol", "LUXE", "BMW","SERIE 7");
//		rentalService.addACar("immat 28", 21500, 70d, 1.5f, (byte) 5, (byte) 5, (byte) 7, "bleu",
//				"automatique", "gazol", "BERLINE","MERCEDES","CLASSE E");
//		rentalService.addACar("immat 29", 11340, 35d, 0.8f, (byte) 4, (byte) 5, (byte) 4, "jaune",
//				"manuelle", "essence", "CITADINE", "RENAULT", "TWINGO");
//		rentalService.addACar("immat 30", 25730, 60d, 1.2f, (byte) 5, (byte) 5, (byte) 6, "rouge",
//				"automatique", "gazol", "FAMILIALE", "PEUGEOT", "5008");
		
//		Page<Cars> carPage = rentalService.carListAvailable(DATE.parse("2018-12-05"), DATE.parse("2018-12-24"), 1, 10);
//		System.out.println(carPage.getTotalElements());

		// LeaseAgreements test
//		rentalService.bookACar("Use1", "immat 1", "2018-08-02", "2018-08-12");
//		rentalService.bookACar("Use2", "immat 4", "2018-09-21", "2018-10-21");
//		rentalService.bookACar("Use1", "immat 7", "2018-12-02", "2018-12-22");
//		rentalService.bookACar("Use3", "immat 9", "2019-02-14", "2019-02-16");
//		rentalService.bookACar("Use2", "immat 5", "2018-11-30", "2018-12-05");
//		leaseService.addNumberAgreement(1, "cont123User1");
//		leaseService.addNumberAgreement(3, "cont678User1");
//		leaseService.addNumberAgreement(4, "cont901User3");
//		leaseService.totalPriceReturnCar("cont123User1", 15000);
		
//		Page<LeaseAgreements> leasePage = leaseService.leaseAgreementPage("null", "Use2", 1, 10);
//		System.out.println(leasePage.getTotalElements());

		//CheckCar test
		
		
		
		// Messages & Newsletters test
//		Date date = new Date();  
//		contactService.addMessage("message1@email.com", "Pierre", "Dupont", "Louez vous des avions, merci", date, false);
//		contactService.addMessage("message2@email.com", "Jean", "Grifon", "Vous etes le meilleur", date, false);
//		contactService.addMessage("message3@email.com", "Eric", "Lafarge", "J'ai besoin de louer 500 mercedes classe S est ce possible ?", date, false);
//		contactService.addNewslettter("premier@email.com");
//		contactService.addNewslettter("second@email.com");
//		contactService.addNewslettter("tertio@email.com");
//		contactService.topicResolut(2, true);
		
//		Page<Messages> messagePage = contactService.viewMessage(DATE.parse("2018-08-12"), DATE.parse("2018-08-16"), false, 1, 5);
//		System.out.println(messagePage.getTotalElements());


		
	}
	
}
