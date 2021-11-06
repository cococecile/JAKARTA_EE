package poei.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	// Show Home Page
	@RequestMapping("/welcome")
	public ModelAndView showWelcomePage() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Home Page.");
		return new ModelAndView("welcome"); // Here welcome is a jsp page name
	}

	// Show Sign-In Form
	@RequestMapping("/login")
	public ModelAndView showSigninForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing login Form Page.");
		ModelAndView mav = new ModelAndView("login"); // Here sign-in is a jsp page name
		mav.addObject("user-sign-in", new UserDto()); // Set the model attribute as "user-sign-in"
		return mav;
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Signin() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing login Form Page.");
		ModelAndView mav = new ModelAndView("login"); // Here sign-in is a jsp page name
		mav.addObject("user-sign-in", new UserDto()); // Set the model attribute as "user-sign-in"
		return mav;
	}

	// Show Sign-Up Form
	@RequestMapping("/subscribe")
	public ModelAndView showSignupForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Subscribe Form Page.");
		ModelAndView mav = new ModelAndView("userCreate"); // Here sign-up is a jsp page name
		mav.addObject("user-sign-up", new UserDto()); // Set the model attribute as "user-sign-up"
		return mav;
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public ModelAndView subscribe() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Subscribe Form Page.");
		ModelAndView mav = new ModelAndView("userCreate"); // Here sign-up is a jsp page name
		mav.addObject("user-sign-up", new UserDto()); // Set the model attribute as "user-sign-up"
		return mav;
	}

}
