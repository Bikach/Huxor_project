package fr.huxor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.huxor.entities.LeaseAgreements;
import fr.huxor.service.ILeaseService;

@Controller
public class UserAccountController {

	@Autowired
	private ILeaseService leaseService;
	
	/**
	 * @return userAccount.html
	 */
	@RequestMapping(value = "/userAccount")
	public String userAccount() {
		// TODO
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
			@RequestParam(name = "size", defaultValue = "10") int size, String user) {

		Page<LeaseAgreements> pageLease = leaseService.leaseAgreementFromUser(user, page, size);
		if (pageLease.getTotalElements() > 0) {
			model.addAttribute("leaseList", pageLease.getContent());
			int[] pages = new int[pageLease.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("lease",leaseService);
		} else {
			String nullList = "Vous n'avez pas de réservations en cours ou passé !";
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
