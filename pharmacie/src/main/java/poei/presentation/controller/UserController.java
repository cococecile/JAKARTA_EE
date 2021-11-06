package poei.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import poei.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

}
