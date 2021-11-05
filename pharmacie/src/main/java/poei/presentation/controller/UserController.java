package poei.presentation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	IUserService userService;

	@RequestMapping("/read-user")
	public String showReadUserPage(Model model) {
		List<UserDto> users = userService.findAll();

		model.addAttribute("users", users );
		return "usersList";
	}

	@RequestMapping("/create-user")
	public String showCreateUserPage(Model model) {
		model.addAttribute("command", new UserDto());
		return "userCreate";
	}

	@RequestMapping(value = "/create-User", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserDto user) {
		userService.createUser(user);
		log.debug("request to save User : {}", user);
		return "redirect:/read-user";
	}

	@RequestMapping(value = "/update-user/{id}")
	public String showUpdateUserPage(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("command", userService.findUser(id));
		return "userUpdate";
	}

	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
	public String updateContact(@PathVariable int id, @ModelAttribute("user") UserDto user) {
		userService.updateUSer(user, id);
		return "redirect:/read-user";
	}

	@RequestMapping(value = "/delete-user/{id}")
	public String deleteContact(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/read-user";
	}
}