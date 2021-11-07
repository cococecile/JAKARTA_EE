package poei.presentation.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

		model.addAttribute("users", users );
		return "usersList";
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
        model.addAttribute("command", userService.findUser(id));
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

