package br.com.daione.pavan.capeonato.handebol.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping("/index")
	public String mainView(Model model) {
	
		
		model.addAttribute("title", "Um Título");
		model.addAttribute("content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer malesuada dolor a convallis auctor. Nulla non turpis vitae lacus aliquam fringilla non quis nisi. Pellentesque euismod laoreet dui. Donec eget mauris nec neque varius cursus sed ut ex. Phasellus eu augue egestas, rhoncus ante id, porta sapien. Aliquam sit amet quam sapien. Fusce vitae lacus sit amet lorem tempor eleifend non id ante. Etiam volutpat purus risus, eu scelerisque erat vulputate eu. Nullam ultricies enim urna, tristique luctus dui finibus vitae. Donec tortor ex, lobortis tempor diam ut, gravida bibendum massa.\r\n" + 
				"\n\n");
		
		return "index";

	}

}
