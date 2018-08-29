package fr.huxor.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.huxor.entities.Addresses;
import fr.huxor.service.IUsersService;

@Controller
public class RegistrationController {
	
	private static int NB_YEAR_MIN= 25;

	@Autowired
	IUsersService userService;

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
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

		List<String> errorsList = new ArrayList<>();

		if (!password.equals(confirmPassword))
			errorsList.add(0, "le mot de passe n'est pas identique ");

		if (!emailValidate(email))
			errorsList.add(1, "l'email est incorrect ");
		
		if(!birthdayValidate(birthday))
			errorsList.add(2, "Vous devez avoir 25 ans minimum au moment de la réservation, merci !");

		if (errorsList.isEmpty()) {
			userService.addCustomer(username, email, new BCryptPasswordEncoder().encode(password), lastName, firstName, false, DATE_FORMAT.parse(birthday),
					driveLicence, new Addresses(street, city, zip));			
			model.addAttribute("succes", "Votre inscription est bien enregistrée, vouscalculer une duree en annee depuis une date anterieur a celle du jour java date pouvez désormée vous connectez avec votre identifiant !");
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
