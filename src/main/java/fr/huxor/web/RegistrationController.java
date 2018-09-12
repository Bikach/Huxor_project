package fr.huxor.web;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.huxor.dao.IRoleRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.Role;
import fr.huxor.service.IUsersService;

@Controller
public class RegistrationController {  
	
	private static final int NB_YEAR_MIN= 25;
 
	@Autowired
	IUsersService userService;
	@Autowired
	IRoleRepository roleRepo;

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	/** 
	 * @return login.html
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	/**
	 * Save a new customer
	 * 
	 * @return login.html
	 * @throws ParseException
	 */
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(Model model, String username, String email, String password, String confirmPassword,
			String lastName, String firstName, String driveLicence, String birthday, String street, String city,
			String zip) throws ParseException {

		HashMap<String, String> errorsList = new HashMap<>();
		Set<Role> roles = new HashSet<>();
		Role role = roleRepo.findByName("USER");
		roles.add(role);

		if (!password.equals(confirmPassword))
			errorsList.put("pass", "le mot de passe n'est pas identique ");

		if (!emailValidate(email)) 
			errorsList.put("email", "l'email est incorrect ");
		
		if(!birthdayValidate(birthday))
			errorsList.put("birth", "Vous devez avoir 25 ans minimum au moment de la réservation, merci !");

		if (errorsList.isEmpty()) {
			userService.addCustomer(username, email, new BCryptPasswordEncoder().encode(password), lastName, firstName, true, LocalDate.parse(birthday),
					driveLicence, new Addresses(street, city, zip), roles);	
			System.out.println("succes");
			model.addAttribute("succes", "Votre inscription est bien enregistrée, vous pouvez désormée vous connectez avec votre identifiant !");
		}else {
			model.addAttribute("errorsMap", errorsList);
		}

		return "login"; 
	}

	/**
	 * Checks the email entered
	 * 
	 * @param emailStr
	 * @return boolean
	 */
	private boolean emailValidate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	/**
	 * Checks if the customer is under 25 years old
	 * 
	 * @param birthdday
	 * @return boolean
	 */
	private boolean birthdayValidate(String birthday) {
		LocalDate birthDate = LocalDate.parse(birthday);
		LocalDate dateDays = LocalDate.now();
		long nbYear =  ChronoUnit.YEARS.between( birthDate, dateDays);
		return (nbYear >= NB_YEAR_MIN)? true : false;
	}
}
