package fr.huxor.web;

import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.huxor.entities.Cars;
import fr.huxor.entities.CustomException;
import fr.huxor.service.IRentalService;

@Controller
public class IndexController { 
	
	@Autowired
	private IRentalService rentalService;


	/**
	 * @return huxor.html
	 */
	@RequestMapping(value = "/huxor")
	public String home() {
		return "index";
	}

	/**
	 * Displays the available cars on the screen
	 * 
	 * @return carsList.html
	 * @throws ParseException 
	 * @throws CustomException 
	 */
	@RequestMapping(value = "/availableCars")
	public String availableCars(Model model,
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="8")int size,
			String startDate, String endDate)  {
		

			Page<Cars> pageCars;
			try {
				pageCars = rentalService.carListAvailable(LocalDate.parse(startDate), LocalDate.parse(endDate), page, size);
				model.addAttribute("carsList", pageCars.getContent());
				int[] pages = new int[pageCars.getTotalPages()];
				model.addAttribute("pages", pages);
				model.addAttribute("startDate", startDate);
				model.addAttribute("endDate", endDate);
				model.addAttribute("rental",rentalService);
			} catch (CustomException e) {
				model.addAttribute("erro", e);
				return "redirect:/?falseDate=" +e.getMessage();
			}
		
		
		return "availableCars";
	}

}
