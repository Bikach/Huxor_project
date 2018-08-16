package fr.huxor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/huxor")
	public String home() {
		return "index";
	}
	
}
