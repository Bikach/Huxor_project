package fr.huxor.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.huxor.entities.Addresses;
import fr.huxor.service.IUsersService;

@Controller
public class RegistrationController {

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

		HashMap<String, String> errorsMap = new HashMap<>();

		if (!password.equals(confirmPassword))
			errorsMap.put("pass", "le mot de passe n'est pas identique ");

		if (!emailValidate(email))
			errorsMap.put("email", "l'email est incorrect ");

		if (errorsMap.isEmpty()) {
			userService.addCustomer(username, email, password, lastName, firstName, false, DATE_FORMAT.parse(birthday),
					driveLicence, new Addresses(street, city, zip));			
			model.addAttribute("succes", "Votre inscription est bien enregistrée, vous pouvez désormée vous connectez avec votre identifiant !");
		}else {
			model.addAttribute("errorsMap", errorsMap);
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
	private boolean birthdayValidate(String birthdday) {

		return false;
	}
}
