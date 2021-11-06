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

	private SessionFactory sessionFactory;

	@Override
	public List<ArticleDo> findAllArticle() {
		try (final Session session = sessionFactory.getCurrentSession()) {
			
			String req = "From Article";

			final Query<ArticleDo> query = session.createQuery(req, ArticleDo.class);
			final List<ArticleDo> listeArticleDo = query.getResultList();
			session.flush();
			
			return listeArticleDo;
		} 
	
	}

	@Override
	public ArticleDo findArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo createArticle(final ArticleDo article) {
		final Session session = sessionFactory.getCurrentSession(); 
			
			session.save(article);

			session.flush();
			
			
			return article;
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
