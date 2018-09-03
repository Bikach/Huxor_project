package fr.huxor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController {

	/**
	 * @return confirmBooking.html
	 */
	@RequestMapping(value = "/user/confirmBooking")
	public String Booking() {
		return "confirmBooking";
	}

	/**
	 * Confirms a car booking
	 * 
	 * @return userAccount.html
	 */
	@RequestMapping(value = "/user/userAccount")
	public String confirmBooking() {
		// TODO
		return "userAccount";
	}

}
