package poei.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poei.persistance.bean.UserDo;
import poei.persistance.dao.IUserDao;
import poei.presentation.bean.UserDto;
import poei.service.IUserService;
import poei.service.util.MD5Encryption;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public UserService() {
		// Empty method
	}

	/**
	 * permet de mapper un userDo en userDto
	 * 
	 * @param user
	 * @return un userDto
	 */
	public static UserDto mapToDto(final UserDo user) {
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
	public static List<UserDto> mapToListDto(final List<UserDo> listeUserDo) {
		final List<UserDto> listeUserDto = new ArrayList<>();
		for (final UserDo userDo : listeUserDo) {
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
	public static UserDo mapToDo(final UserDto userDto) {
		final String newPassword = MD5Encryption.encrypt(userDto.getMot_de_passe());
		final UserDo userDo = UserDo.buildUserDo(userDto.getId(), userDto.getName(), userDto.getPrenom(),
				userDto.getAdresse(), newPassword, userDto.getEmail());
		return userDo;
	}
	/**	
	@Override
	public List<UserDto> findAll() {
		List<UserDto> liste = mapToListDto(userDao.findAllUser());
		return liste;
	}
	*/
	
}
