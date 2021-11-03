package poei.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller

@RequestMapping("/userDto")
public class UserController {

	@Autowired
	private IUserService userService;

	// Show All User
	@GetMapping("/users")
	public ModelAndView showAllEmployees() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing users list.");
		ModelAndView mav = new ModelAndView("usersList"); // Here employees is a jsp page name
		List<UserDto> users = userService.findAll();
		mav.addObject("users", users); // Set the attribute as "users"
		return mav;
	}

}
