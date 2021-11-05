package poei.persistance.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poei.persistance.bean.UserDo;
import poei.persistance.dao.IUserDao;

@Repository
@Transactional
public class UserDao implements IUserDao {


	private SessionFactory sessionFactory;

	@Override
	public List<UserDo> findAllUser() {
		try (
			 Session session = sessionFactory.getCurrentSession()) {
			 Transaction transaction = session.beginTransaction();
			String req = "select * from utilisateur";
            UserDo user1= new UserDo(1,"karima","karima","adresse","mail@gmail","kjdlkhklhd");
			final Query<UserDo> query = session.createQuery(req, UserDo.class);
			final List<UserDo> listeUserDo = query.getResultList();
			listeUserDo.add(user1);
			session.flush();
			transaction.commit();
			
			return listeUserDo;

			// On gère l'exception
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public UserDo findUser(final int id) {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			final Query<UserDo> query = session.createQuery("select from utilisateur where id = :id", UserDo.class);
			// on initialise le paramètre
			query.setParameter("id", id);
			// regarder la Javadoc de Optional
			final Optional<UserDo> userDo = query.uniqueResultOptional();
			session.flush();
			transaction.commit();
			// suite de la feature Optional de Java 8
			return userDo.orElse(null);
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDo findConnectedUSer(final String email, final String mot_de_passe) {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			final Query<UserDo> query = session
					.createQuery("select From utilisateur where email = :email and mot_de_passe = :mot_de_passe", UserDo.class);
			// on initialise le paramètre
			query.setParameter("email", email);
			query.setParameter("mot_de_passe", mot_de_passe);
			// regarder la Javadoc de Optional
			final Optional<UserDo> userDo = query.uniqueResultOptional();

			session.flush();
			transaction.commit();
			// suite de la feature Optional de Java 8
			return userDo.orElse(null);
		} catch (final HibernateException hibernateException) {
			// on peut catcher des HibernateException
			hibernateException.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDo create(final UserDo userDo) {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();

			session.save(userDo);
			session.flush();

			transaction.commit();

			return userDo;
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDo update(final UserDo userDo, final int id) {
		try (final Session session = sessionFactory.getCurrentSession()) {
			// sans auto-commit , on doit créer une transaction
			final Transaction transaction = session.beginTransaction();
			final StringBuilder hqlQuery = new StringBuilder();
			hqlQuery.append(
					"update utilisateur set nom = :nom, prenom = :prenom,adresse = :adresse, email = :email, mot_de_passe = :mot_de_passe  where id = :id");

			final Query<?> query = session.createQuery(hqlQuery.toString());
			// intialisation des paramètres
			query.setParameter("nom", userDo.getNom());
			query.setParameter("prenom", userDo.getPrenom());
			query.setParameter("adresse", userDo.getAdresse());
			query.setParameter("email", userDo.getEmail());
			query.setParameter("mot_de_passe", userDo.getMot_de_passe());
			query.executeUpdate();

			session.flush();
			transaction.commit();
			
			// on "complète" le Do à retourner
			userDo.setId(id);
			return userDo;
		} catch (final HibernateException hibernateException) {
			// on peut catcher des HibernateException
			hibernateException.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(final int id) {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();

			// delete dans query,
			final UserDo userDo = session.load(UserDo.class, id);
			if (null != userDo) {
				session.delete(userDo);

				session.flush();
				transaction.commit();
				return true;
			}

		} catch (final HibernateException | EntityNotFoundException exception) {
			exception.printStackTrace();
		}

		return false;
	}

}
