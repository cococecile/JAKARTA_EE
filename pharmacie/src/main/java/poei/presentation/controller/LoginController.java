package poei.presentation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.LoginForm;
import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService userService;

	// Show Home Page
	@RequestMapping("/welcome")
	public ModelAndView showWelcomePage() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Home Page.");
		return new ModelAndView("welcome"); // Here welcome is a jsp page name
	}

	// Show Sign-In Form
	@GetMapping({ "/", "/login" })
	public ModelAndView showSigninForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing login Form Page.");
		ModelAndView mav = new ModelAndView("login"); // Here sign-in is a jsp page name
		mav.addObject("loginForm", new LoginForm()); // Set the model attribute as "user-sign-in"
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Signin(HttpSession session, Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
		final UserDto connectedUser = userService.findUserForConnexion(loginForm.getEmail(), loginForm.getPassword());
		if (null != connectedUser) {
			session.setAttribute("connectedUser", connectedUser);
			return new ModelAndView("welcome");
		}
		return new ModelAndView("login");
	}

	@GetMapping({ "/logout" })
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("connectedUser");
		ModelAndView model = new ModelAndView("login");
		model.addObject("loginForm", new LoginForm());
		return model;
	}

}
