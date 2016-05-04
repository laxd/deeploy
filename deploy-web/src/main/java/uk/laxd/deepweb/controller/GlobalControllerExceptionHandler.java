package uk.laxd.deepweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lawrence on 03/05/16.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleException(Exception exception, HttpServletRequest request) throws Exception {
        LOGGER.error("Received exception: {}", exception.getMessage());

        if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null) {
            throw exception;
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("deeploy-error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        modelAndView.addObject("url", request.getRequestURL());

        return modelAndView;
    }
}
