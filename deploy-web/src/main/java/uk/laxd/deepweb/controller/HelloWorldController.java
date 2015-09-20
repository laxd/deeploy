package uk.laxd.deepweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lenny on 19/09/2015.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView sayHello(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("message", "Hello from controller!");

        return modelAndView;
    }

}
