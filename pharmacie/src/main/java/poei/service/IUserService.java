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

	/**
	 * Permet de chercher un user à partir de son id
	 * 
	 * @param id
	 * @return user
	 */
	UserDto findUser(final int id);

	/**
	 * Permet de matcher un email et le mot de passe
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	UserDto findUserForConnexion(final String email, final String password);

	/**
	 * Permet de creer un user
	 * 
	 * @param userDto
	 * @return createdUser
	 */
	UserDto createUser(final UserDto userDto);

	/**
	 * Permet de mettre à jour un user
	 * 
	 * @param userDto
	 * @param id
	 * @return updatedUser
	 */
	UserDto updateUSer(final UserDto userDto, final int id);

	/**
	 * Permet de supprimer un user à partir de son id
	 * 
	 * @param id
	 */
	void delete(final int id);

}
