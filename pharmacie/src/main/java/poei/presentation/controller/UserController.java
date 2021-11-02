package poei.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller

public class UserController {

	@Autowired
	private IUserService userService;

	public UserController() {
		// Empty method
	}
	
	 @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	    public String index(Model model) {

	        String message = "GESTION DES ARTICLES DE LA PHARMACIE";

	        model.addAttribute("message", message);

	        return "index";
	    }
	
	 @RequestMapping(value = { "/usersList" }, method = RequestMethod.GET)
	public String findAllUser(Model model) {
		List<UserDto> users = userService.findAll();
		
		model.addAttribute("users", users);
		
		return "usersList";
		
	}

}
