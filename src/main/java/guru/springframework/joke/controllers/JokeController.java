package guru.springframework.joke.controllers;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.joke.services.JokeService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JokeController {
	
	private JokeService jokeService;

	@Autowired
	public JokeController(JokeService jokeService) {
		this.jokeService = jokeService;
	}
	
	@RequestMapping({"/",""})
	public String showJoke(Model model) {
		
		model.addAttribute("joke", jokeService.getJoke());
		
		return "sub/chucknorris";
		
	}
	
	@RequestMapping("/nameList/{count}")
	public String showNames(@PathVariable Integer count, Model model) throws Exception {
		
			model.addAttribute("name", jokeService.getRandomNames(count));
		return "namelist";
	}
	
//	@RequestMapping("/nameList/{count}")
//	public String showNames(@PathVariable Integer count, Model model) throws Exception {
//		
//		try {
//			model.addAttribute("name", jokeService.getRandomNames(count));
//		} catch (Exception e) {
//			//throw new RuntimeException("Controller " + e.getMessage());
//		}
//		return "namelist";
//	}
	
//	
//	@ExceptionHandler(Exception.class)
//	  public ModelAndView handleError(HttpServletRequest req, Exception ex) {
//	    log.error("Request: " + req.getRequestURL() + " raised " + ex);
//
//	    ModelAndView mav = new ModelAndView();
//	    mav.addObject("message", ex.getLocalizedMessage());
//	    mav.addObject("url", req.getRequestURL());
//	    mav.setViewName("error");
//	    return mav;
//	  }
	
	
}
