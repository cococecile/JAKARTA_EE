package poei.persistance.dao;

import java.util.List;

import poei.persistance.bean.User;

public interface IUserDao {

	/**
	 * Permet de rechercher tous les User en BDD
	 * 
	 * @return la liste des users par ordre alphabÃ©tique
	 */
	List<User> findAllUser();

}
