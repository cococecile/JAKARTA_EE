package poei.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poei.persistance.bean.UserDo;
import poei.persistance.dao.IUserDao;
import poei.presentation.bean.UserDto;
import poei.service.IUserService;
import poei.util.cryptage.MD5Encryption;

@Service("UserService")
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	

	/**
	 * permet de mapper un userDo en userDto
	 * 
	 * @param user
	 * @return userDto
	 */
	public UserDto mapToDto(final UserDo user) {
		final UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setNom(user.getNom());
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
	 * @return listeUserDto
	 */
	public List<UserDto> mapToListDto(final List<UserDo> listeUserDo) {
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
	public UserDo mapToDo(final UserDto userDto) {
		final String newPassword = MD5Encryption.encrypt(userDto.getMot_de_passe());
		final UserDo userDo = UserDo.buildUserDo(userDto.getId(), userDto.getNom(), userDto.getPrenom(),
				userDto.getAdresse(), newPassword, userDto.getEmail());
		return userDo;
	}

	@Override
	public List<UserDto> findAll() {
		final List<UserDo> users = userDao.findAllUser();
		final List<UserDto> liste = mapToListDto(users);

		return liste;
	}

	@Override
	public UserDto findUserForConnexion(final String email, final String password) {
		 
		final String cryptPassword = MD5Encryption.encrypt(password);
		final UserDo connectedUser = userDao.findConnectedUSer(email,cryptPassword);
		if (null != connectedUser) {
			return mapToDto(connectedUser);
		}
		return null;
	}

	@Override
	public UserDto findUser(final int id) {
		final UserDto userDto = mapToDto(userDao.findUser(id));
		if (userDto != null) {
			return userDto;
		} 
		return null;
	}

	@Override
	public UserDto createUser(final UserDto userDto) {
		UserDo user = new UserDo();
		 user = mapToDo(userDto);
                     user =userDao.create(user);
					 System.out.println("ajout user");
		final UserDto createdUser = mapToDto(user);
		if (createdUser!= null) {
			System.out.println("ajout user");
			return createdUser;

		}
		return null;
	}

	@Override
	public UserDto updateUSer(final UserDto userDto, final int id) {
		final UserDto updatedUser = mapToDto(userDao.update(mapToDo(userDto), id));
		if (updatedUser != null) {
			return updatedUser;
		}
		return null;
	}

	@Override
	public boolean delete(final int id) {
		final boolean resulat = userDao.delete(id);
		return resulat;

	}

}
