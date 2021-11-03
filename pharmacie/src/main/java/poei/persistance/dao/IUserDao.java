package poei.persistance.dao;

import java.util.List;

import poei.persistance.bean.UserDo;
import poei.presentation.bean.UserDto;

public interface IUserDao {

	/**
	 * Permet de rechercher tous les Users en BDD
	 * 
	 * @return users
	 */
	List<UserDo> findAllUser();

	/**
	 * Permet de chercher un user à partir de son id
	 * 
	 * @param id
	 * @return user
	 */
	UserDo findUser(final int id);

	/**
	 * Permet de retrouver un user à partir de son email et son password
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	UserDo findConnectedUSer(String email, String password);

	/**
	 * Permet de creer un user
	 * 
	 * @param userDo
	 * @return
	 */
	UserDo create(final UserDo userDo);

	/**
	 * Permet de mettre à jour un user
	 * 
	 * @param userDo
	 * @param id
	 * @return user
	 */
	UserDo update(final UserDo userDo, final int id);

	
	/**
	 * Permet de supprimer un user
	 * @param id
	 * @return true if deleted else false
	 */
	boolean delete(final int id);
}
