package poei.presentation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ResponseStatus;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;
import poei.service.imp.UserService;

@Controller
public class UserController {
	

	@Autowired
	UserService userService;


	@RequestMapping("/usersList")
	public ModelAndView usersList(Model model) {
		List<UserDto> users = userService.findAll();
		model.addAttribute("users", users);
		return new ModelAndView("usersList");
	}

	

	@RequestMapping("/create-user")
	public String showCreateUserPage(Model model) {
		model.addAttribute("user",new UserDto());
		return "userCreate";
	}
	

	@RequestMapping(value ="/create-User", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserDto user) {
		
		UserDto newuser = userService.create(user);
		if (null != newuser) {
			
			return "redirect:/read-user";
			
		}
		return "redirect:/userCreate";

    }

    @RequestMapping(value = "/update-user/{id}")
    public String showUpdateUserPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("user", userService.findUser(id));
        return "userUpdate";
    }

    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable int id, @ModelAttribute("user")  UserDto user) {
        userService.updateUSer(user, id);
        return "redirect:/read-user";
    }

	@RequestMapping(value = "/delete-user/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/read-user";
	}
}

