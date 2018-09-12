package fr.huxor.web;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
	public String confirmBooking(Model model, String licencePlate, 
			String startDate, String endDate) {
		try {
			Cars car = rentalService.findACar(licencePlate);
			LocalDate pickup = LocalDate.parse(startDate);
			LocalDate drop = LocalDate.parse(endDate);
			int nbDays =  (int) ChronoUnit.DAYS.between(pickup, drop);
			model.addAttribute("car", car);
			model.addAttribute("nbDays", nbDays);
		} catch (CustomException e) {
			model.addAttribute("error", e);
		}
		return "confirmBooking";
	}
 
	@RequestMapping(value="/save")
	public String save(Model model, String user, String licencePlate, String startDate, String endDate, String price) {
		
		try {
			rentalService.bookACar(user, licencePlate, startDate, endDate);
		} catch (CustomException | ParseException e) {
			model.addAttribute("error", e);
		}
		
		return "redirect:/confirmBooking?user=" +user+ "&licencePlate=" +licencePlate
				+ "&startDate=" +startDate+ "&endDate=" +endDate+ "&price=" +price
				+ "&succesBook=Reservation enregistree dans votre compte client avec succes !" ;
	}
	


}
