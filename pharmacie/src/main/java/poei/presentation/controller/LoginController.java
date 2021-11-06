package poei.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService userService;
	

	// Show Home Page
	@GetMapping({ "/", "/welcome" })
	public ModelAndView showHomePage() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Home Page.");
		return new ModelAndView("welcome"); // Here welcome is a jsp page name
	}

	// Show Sign-Up Form
	@GetMapping("/subscribe")
	public ModelAndView showSignupForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Subscribe Form Page.");
		ModelAndView mav = new ModelAndView("userCreate"); // Here sign-up is a jsp page name
		mav.addObject("user-sign-up", new UserDto()); // Set the model attribute as "user-sign-up"
		return mav;
	}

	// Show Sign-In Form
	@GetMapping("/login")
	public ModelAndView showSigninForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing login Form Page.");
		ModelAndView mav = new ModelAndView("login"); // Here sign-in is a jsp page name
		mav.addObject("user-sign-in", new UserDto()); // Set the model attribute as "user-sign-in"
		return mav;
	}

}
