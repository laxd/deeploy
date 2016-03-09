package uk.laxd.deepweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
}
