package poei.persistance.dao.imp;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;

@Repository
@Transactional
public class ArticleDao implements IArticleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ArticleDo> findAllArticle() {
		String req = "From ArticleDo";
		final Session session = sessionFactory.getCurrentSession();

		final Query<ArticleDo> query = session.createQuery(req, ArticleDo.class);
		final List<ArticleDo> listeArticleDo = query.getResultList();
		session.flush();

		return listeArticleDo;
	}

	/**
	 * @override est utilisé pour définir une méthode qui est héritée de la classe
	 *           parente
	 */
	@Override
	public ArticleDo findArticleById(final int id) {
		final Session session = sessionFactory.getCurrentSession();
		final Query<ArticleDo> query = session.createQuery("From ArticleDo where id = :idParam", ArticleDo.class);
		// on initialise le paramètre
		query.setParameter("idParam", id);
		// regarder la Javadoc de Optional
		final Optional<ArticleDo> articleDo = query.uniqueResultOptional();

		session.flush();
		// suite de la feature Optional de Java 8
		return articleDo.orElse(null);
	}

	@Override
	public ArticleDo createArticle(final ArticleDo articleDo) {

		final Session session = sessionFactory.getCurrentSession();

		session.save(articleDo);

		session.flush();

		return articleDo;
	}

	@Override
	public boolean deleteArticle(final int id) {
		final Session session = sessionFactory.getCurrentSession();
		// delete avec query
		final Query<?> query = session.createQuery("delete from ArticleDo where id = :idArticleDo");
		query.setParameter("idArticleDo", id);
		final int result = query.executeUpdate();
		// delete sans query
		// final ArticleDo articleDo = session.load(ArticleDo.class, idArticleDo);
		// session.delete(articleDo);

		session.flush();
		if (result == 1) {
			return true;
		}

		return false;

	}

	@Override
	public ArticleDo updateArticle(final ArticleDo articleDo, final int id) {
		try (final Session session = sessionFactory.getCurrentSession()) {

			final StringBuilder hqlQuery = new StringBuilder();
			hqlQuery.append(
					"update ArticleDo set designation = :designation, description = :description where id = :id");

			final Query<?> query = session.createQuery(hqlQuery.toString());
			// initialisation des paramètres
			query.setParameter("designation", articleDo.getDesignation());
			query.setParameter("description", articleDo.getDescription());
			query.setParameter("quantite", articleDo.getQuantite());
			query.executeUpdate();

			articleDo.setId(id);

			session.flush();

			return new ArticleDo();

			// On gère l'exception
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return null;

	}
}
