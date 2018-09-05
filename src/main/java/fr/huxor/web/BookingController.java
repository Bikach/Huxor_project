package fr.huxor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.service.IRentalService;

@Controller
public class BookingController {
	
	@Autowired
	private IRentalService rentalService;
	
	

	/**
	 * @return confirmBooking.html
	 */
	@RequestMapping(value = "/confirmBooking")
	public String Booking(Model model, String licencePlate) {
		try {
			Cars car = rentalService.findACar(licencePlate);
			double dailyPrice = car.getDailyPrice();
			model.addAttribute("car", car);
		} catch (CustomException e) {
			model.addAttribute("error", e);
		}
		return "confirmBooking";
	}

	/**
	 * Confirms a car booking
	 * 
	 * @return userAccount.html
	 */
	@RequestMapping(value = "/userAccount")
	public String confirmBooking() {
		// TODO
		return "userAccount";
	}

}
