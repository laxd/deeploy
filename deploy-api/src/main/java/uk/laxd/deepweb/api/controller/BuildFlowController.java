package uk.laxd.deeploy.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BuildFlowController {

	@RequestMapping("/")
	public String test() {
		return "Test Success!";
	}


}
