package poei.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import poei.persistance.bean.User;
import poei.persistance.dao.IUserDao;
import poei.presentation.bean.UserDto;
import poei.service.IUserService;
import poei.service.util.MD5Encryption;

public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	/**
	 * permet de mapper un userDo en userDto
	 * 
	 * @param user
	 * @return un userDto
	 */
	public static UserDto mapToDto(final User user) {
		final UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPrenom(user.getPrenom());
		userDto.setAdresse(user.getAdresse());
		userDto.setMot_de_passe(user.getMot_de_passe());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	/**
	 * permet de mapper une liste de userDo en liste de userDto
	 * 
	 * @param listeUserDo
	 * @return
	 */
	public static List<UserDto> mapToListDto(final List<User> listeUserDo) {
		final List<UserDto> listeUserDto = new ArrayList<>();
		for (final User userDo : listeUserDo) {
			listeUserDto.add(mapToDto(userDo));
		}
		return listeUserDto;
	}

	/**
	 * permet de mapper le userDto en userDo
	 * 
	 * @param userDto
	 * @return le userDo
	 */
	public static User mapToDo(final UserDto userDto) {
		final String newPassword = MD5Encryption.encrypt(userDto.getMot_de_passe());
		final User userDo = User.buildUserDo(userDto.getId(), userDto.getName(), userDto.getPrenom(),
				userDto.getAdresse(), newPassword, userDto.getEmail());
		return userDo;
	}
	
	@Override
	public List<UserDto> findAll() {
		List<UserDto> liste = mapToListDto(userDao.findAllUser());
		return liste;
	}
	
	
}
