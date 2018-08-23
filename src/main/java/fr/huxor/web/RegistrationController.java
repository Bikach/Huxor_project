package fr.huxor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

}
