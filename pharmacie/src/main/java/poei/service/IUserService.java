package poei.service;

public interface IUserService {

	/**
	 * Permet de retourner la lste de tous les user
	 * 
	 * @return liste
	 */
	List<UserDto> findAll();

	/**
	 * Permet de matcher un email et le mot de passe
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	boolean validate(String email, String password);

}
