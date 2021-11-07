package poei.persistance.dao.imp;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poei.persistance.bean.UserDo;
import poei.persistance.dao.IUserDao;

@Repository
@Transactional
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<UserDo> findAllUser() {
		String req = "From UserDo";
		Session session = this.sessionFactory.getCurrentSession();

		final Query<UserDo> query = session.createQuery(req, UserDo.class);
		final List<UserDo> listeUserDo = query.getResultList();

		session.flush();

		return listeUserDo;

	}

	@Override
	public UserDo findUser(final int id) {
		final Session session = sessionFactory.getCurrentSession();

		final Query<UserDo> query = session.createQuery("from UserDo where id = :id", UserDo.class);
		// on initialise le paramètre
		query.setParameter("id", id);
		// regarder la Javadoc de Optional
		final Optional<UserDo> userDo = query.uniqueResultOptional();
		session.flush();

		// suite de la feature Optional de Java 8
		return userDo.orElse(null);
	}

	@Override
	public UserDo findConnectedUSer(final String email, final String mot_de_passe) {
		final Session session = sessionFactory.getCurrentSession();

		final Query<UserDo> query = session
				.createQuery("From UserDo where email = :email and mot_de_passe = :mot_de_passe", UserDo.class);
		// on initialise le paramètre
		query.setParameter("email", email);
		query.setParameter("mot_de_passe", mot_de_passe);
		// regarder la Javadoc de Optional
		final Optional<UserDo> userDo = query.uniqueResultOptional();

		session.flush();
		// suite de la feature Optional de Java 8
		return userDo.orElse(null);

	}

	@Override
	public UserDo create(final UserDo userDo) {

		final Session session = sessionFactory.getCurrentSession();

		session.save(userDo);
		session.flush();

		return userDo;

	}

	@Override
	public UserDo update(final UserDo userDo, final int id) {
		final Session session = sessionFactory.getCurrentSession();
		// sans auto-commit , on doit créer une transaction

		final StringBuilder hqlQuery = new StringBuilder();
		hqlQuery.append(
				"update userDo  set nom = :nom, prenom = :prenom,adresse = :adresse, email = :email, mot_de_passe = :mot_de_passe  where u.id = :id");

		final Query<?> query = session.createQuery(hqlQuery.toString());
		// intialisation des paramètres
		query.setParameter("nom", userDo.getNom());
		query.setParameter("prenom", userDo.getPrenom());
		query.setParameter("adresse", userDo.getAdresse());
		query.setParameter("email", userDo.getEmail());
		query.setParameter("mot_de_passe", userDo.getMot_de_passe());
		query.executeUpdate();

		session.flush();

		// on "complète" le Do à retourner
		userDo.setId(id);
		return userDo;
	}

	@Override
	public boolean delete(final int id) {
		Boolean res = false;
		final Session session = sessionFactory.getCurrentSession();

		// delete dans query,

		final UserDo userDo = session.load(UserDo.class, id);
		if (null != userDo) {
			session.delete(userDo);

			session.flush();
			res = true;
		}
		return res;
	}

}
