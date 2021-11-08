package poei.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;

	public ModelAndView userCreate() {
		return new ModelAndView("userCreate");
	}

	@RequestMapping("/read-user")
	public String showReadUserPage(Model model) {
		List<UserDto> users = userService.findAll();

		model.addAttribute("users", users);
		return "usersList";
	}

	/**
	 * Permet d'afficher le formulaire de création d'un user
	 * 
	 * @param model
	 * @return direction vers la jsp userCreate
	 */
	@RequestMapping("/create-user")
	public String showCreateUserPage(Model model) {

		model.addAttribute("user", new UserDto());
		return "userCreate";
	}

	/**
	 * Permet de créer un user
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserDto user) {
		UserDto newUser = userService.create(user);
		if (null != newUser) {
			return "redirect:/read-user";
		}

		return "redirect:/create-user";

	}

	@RequestMapping(value = "/update-user/{id}")
    public String showUpdateUserPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("user", userService.findUser(id));
        return "userUpdate";
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") UserDto user) {
        UserDto updatedUser= userService.updateUSer(user, user.getId());
        if (updatedUser != new UserDto()) {
            return "redirect:/read-user";

        }
        return "redirect:/update-user";

    }

	@RequestMapping(value = "/delete-user/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/read-user";
	}
	
	/**
	 * Permet de recuperer le connectedUSer
	 * 
	 * @return redirection vers la jsp infoUser
	 */
	@RequestMapping("/user")
	public ModelAndView getUserAccount(HttpSession session, Model model) {
		
		UserDto userDto = (UserDto) session.getAttribute("connectedUser");

		model.addAttribute("user",userDto);

		return new ModelAndView("userInfo");
	}
	
	/**
	 * Permet de recuperer un user à partir de son id 
	 * 
	 * @return redirection vers la jsp infoUser
	 */
	@RequestMapping("/user/{id}")
	public ModelAndView getUser(@PathVariable int id, Model model) {
		
		
		model.addAttribute("user",userService.findUser(id));

		return new ModelAndView("userInfo");
	}

}
