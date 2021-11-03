package poei.persistance.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;

@Service
public class ArticleDao implements IArticleDao {

	private static SessionFactory sessionFactory;

	public static List<ArticleDo> findAllArticles() {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			String req = "From Article";

			final Query<ArticleDo> query = session.createQuery(req, ArticleDo.class);
			final List<ArticleDo> listeArticleDo = query.getResultList();
			session.flush();
			transaction.commit();
			return listeArticleDo;

			// On gère l'exception
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return new ArrayList<>();
	}

	public ArticleDo updateArticle() {
		try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			String req = "From Article";

			final Query<ArticleDo> query = session.createQuery(req, ArticleDo.class);
			query.getResultList();
			session.flush();
			transaction.commit();
			return new ArticleDo();

			// On gère l'exception
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return new ArticleDo();

	}

	@Override
	public List<ArticleDo> findAllArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo findArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo createArticle(ArticleDo article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo updateArticle(ArticleDo articleDo, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
