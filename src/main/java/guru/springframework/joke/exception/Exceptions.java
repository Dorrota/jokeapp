package guru.springframework.joke.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Exceptions {
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception ex) {
	    log.error("Request: " + req.getRequestURL() + " raised " + ex);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("message", ex.getLocalizedMessage());
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }

}
