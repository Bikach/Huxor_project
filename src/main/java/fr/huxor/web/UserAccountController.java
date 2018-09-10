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
	 * 
	 * @param model
	 * @param page
	 * @param size
	 * @param user
	 * @return mysReservations.html
	 */
	@RequestMapping(value="/myReservations")
	public String myReservation(Model model, 
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="10")int size,
			String user) {
			
		Page<LeaseAgreements> pageLease = leaseService.leaseAgreementFromUser(user, page, size);
		if (pageLease.getTotalElements() > 0) {			
			model.addAttribute("leaseList", pageLease.getContent());
			int[] pages = new int[pageLease.getTotalPages()];
			model.addAttribute("pages", pages);
		}else {
			String nullList = "Vous navez pas encore de réservations à votre active !";
			model.addAttribute("nullList", nullList);
		}

		return "myReservations";
	}
	

	
}
