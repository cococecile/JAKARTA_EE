package poei.persistance.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poei.persistance.bean.UserDo;
import poei.persistance.dao.IUserDao;





@Repository

public class UserDao implements IUserDao {

	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<UserDo> findAllUser() {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			String req = "From User";

			final Query<UserDo> query = session.createQuery(req, UserDo.class);
			final List<UserDo> listeUserDo = query.getResultList();
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
