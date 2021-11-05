package poei.presentation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller
@RequestMapping("/connexion")
public class LoginController {

	@Autowired
	private IUserService userService;
	

	// Show Home Page
	@GetMapping(value = { "/", "/home", "/welcome", "default" })
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

	// Show welcome page after successful login
	@GetMapping("/welcome")
	public ModelAndView welcomeMessage() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Welcome Page.");
		return new ModelAndView("welcome"); // Here welcome is a jsp page name
	}

	// Validate User through login Process
	@PostMapping("/validateUser")
	public ModelAndView validateEmployee(@Validated @ModelAttribute("user-sign-in") UserDto userDto, BindingResult bindingResult,
			HttpSession session) {

		UserDto userExist = userService.findUserForConnexion(userDto.getEmail(), userDto.getMot_de_passe());
		// Check if user exists
		if (userExist == null) {
			bindingResult.rejectValue("email", "error.user", "Identifiant n'existe pas! Mersi de créer un compte");
			return new ModelAndView("userCreate");
		} else {
			session.setAttribute("prenom", userExist.getPrenom() + " " + userExist.getNom());
			return new ModelAndView("welcome");

		}
	}
}
