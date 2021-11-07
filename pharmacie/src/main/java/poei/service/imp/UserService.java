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

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	

	/**
	 * permet de mapper un userDo en userDto
	 * 
	 * @param user
	 * @return userDto
	 */
	public UserDto mapToUserDto(final UserDo user) {
		 UserDto userDto = new UserDto();
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
			listeUserDto.add(mapToUserDto(userDo));
		}
		return listeUserDto;
	}

	/**
	 * permet de mapper le userDto en userDo
	 * 
	 * @param userDto
	 * @return le userDo
	 */
	public UserDo mapToUserDo(UserDto user) {
		UserDo userDo = new UserDo();
		userDo.setId(user.getId());
		userDo.setNom(user.getNom());
		userDo.setPrenom(user.getPrenom());
		userDo.setAdresse(user.getAdresse());
		userDo.setMot_de_passe(user.getMot_de_passe());
		userDo.setEmail(user.getEmail());

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
			return mapToUserDto(connectedUser);
		}
		return null;
	}

	@Override
	public UserDto findUser(final int id) {
		final UserDto userDto = mapToUserDto(userDao.findUser(id));
		if (userDto != null) {
			return userDto;
		} 
		return null;
	}

	@Override
	public UserDto create(final UserDto userDto) {
		final UserDo user = userDao.create(mapToUserDo(userDto));
		final UserDto newUser = mapToUserDto(user);
		if (null != newUser) {
			return newUser;

		}

		return new UserDto();}
		 

	@Override
	public UserDto updateUSer(UserDto userDto, int id) {
		UserDo userDo = userDao.findUser(id);
		if (null != userDo) {
			
			userDo.setId(userDto.getId());
		userDo.setNom(userDto.getNom());
		userDo.setPrenom(userDto.getPrenom());
		userDo.setAdresse(userDto.getAdresse());
		userDo.setMot_de_passe(userDto.getMot_de_passe());
		userDo.setEmail(userDto.getEmail());
			final UserDo updatedUser = userDao.update(userDo, id);
			return mapToUserDto(updatedUser);
		}

		return null;
	}

	@Override
	public boolean delete(final int id) {
		final boolean resulat = userDao.delete(id);
		return resulat;

	}
	public UserDto getById(int id) {
		// on va récupérer l'id dans une variable
		final UserDto userDto = mapToUserDto(userDao.findUser(id));
		
		if (userDto == null){
			return null;
		}
		
			return userDto;
		
	}
}
