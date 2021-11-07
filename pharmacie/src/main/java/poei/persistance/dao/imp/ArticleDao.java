package poei.persistance.dao.imp;

import java.util.List;

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

	@Override
	public ArticleDo findArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo createArticle(final ArticleDo articleDo) {

		final Session session = sessionFactory.getCurrentSession();

		session.save(articleDo);

		session.flush();

		return articleDo;
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

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
