package fr.huxor.web;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.LeaseAgreements;
import fr.huxor.service.ILeaseService;
import fr.huxor.service.IUsersService;

@Controller
public class UserAccountController {

	@Autowired
	private ILeaseService leaseService;
	@Autowired
	private IUsersService userService;

	/**
	 * View user profile
	 * 
	 * @param model
	 * @param username
	 * @return myProfile.html
	 */
	@RequestMapping(value = "/userAccount")
	public String userAccount(Model model, String username) {

		try {
			Customers user = (Customers)userService.findAUser(username);			
			long age = ChronoUnit.YEARS.between(user.getBirthDate(), LocalDate.now());
			model.addAttribute("age", age);
			model.addAttribute("user", user);
		} catch (CustomException e) {
			model.addAttribute("error", e);
		}
		
		return "userAccount";
	}

	/**
	 * Manage my reservation list
	 * 
	 * @param model
	 * @param page
	 * @param size
	 * @param user
	 * @return mysReservations.html
	 */
	@RequestMapping(value = "/myReservations")
	public String myReservation(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size, String username) {

		Page<LeaseAgreements> pageLease = leaseService.leaseAgreementFromUser(username, page, size);
		if (pageLease.getTotalElements() > 0) {
			model.addAttribute("leaseList", pageLease.getContent());
			int[] pages = new int[pageLease.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("leaseService", leaseService);
		} else {
			String nullList = "Vous n'avez pas de réservations en cours ou passés !";
			model.addAttribute("nullList", nullList);
		}

		return "myReservations";
	}

	/**
	 * Deletes leases that have not yet occurred
	 * 
	 * @param id
	 * @param user
	 * @param page
	 * @param size
	 * @return myReservations.html
	 */
	@RequestMapping(value = "/delete")
	public String delete(String id, String user, int page, int size) {
		leaseService.deleteLease(Long.parseLong(id));
		return "redirect:/myReservations?user=" + user + "&page=" + page + "&size=" + size;
	}

}
