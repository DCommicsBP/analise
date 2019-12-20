package br.com.daione.pavan.capeonato.handebol.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping("")
	public String mainRoute(Model model) {
		
		return "index";
	}
	
}
