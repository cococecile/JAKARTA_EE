package poei.persistance.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import poei.persistance.bean.User;
import poei.persistance.dao.IUserDao;
import poei.persistance.factory.HibernateFactory;


@Repository
public class UserDao implements IUserDao {

	private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
	// private static final SessionFactory sessionFactory = new
	// Configuration().configure().buildSessionFactory();

	@Override
	public List<User> findAllUser() {
		try (final Session session = sessionFactory.openSession()) {
			final Transaction transaction = session.beginTransaction();
			String req = "From User";

			final Query<User> query = session.createQuery(req, User.class);
			final List<User> listeUserDo = query.getResultList();
			session.flush();
			transaction.commit();
			return listeUserDo;

			// On gère l'exception
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return new ArrayList<>();
	}

}
