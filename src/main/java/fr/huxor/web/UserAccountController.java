package fr.huxor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAccountController {

	@RequestMapping(value = "/userAccount")
	public String userAccount() {
		// TODO
		return "userAccount";
	}
	
	@RequestMapping(value="/myReservations")
	public String myReservation() {
		// TODO
		return "myReservations";
	}
	

	
}
