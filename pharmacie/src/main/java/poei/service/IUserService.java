package poei.service;

import java.util.List;

import poei.presentation.bean.UserDto;

public interface IUserService {

	/**
	 * Permet de retourner la lste de tous les user
	 * 
	 * @return utilisateurs
	 */
	List<UserDto> findAll();

}
