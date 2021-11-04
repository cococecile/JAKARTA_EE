package poei.persistance.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;

@Service
public class ArticleDao implements IArticleDao {

	private static SessionFactory sessionFactory;

	@Override
	public List<ArticleDo> findAllArticle() {
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

	/**
	 * @override est utilisé pour définir une méthode qui est héritée de la classe parente 
	 */
	@Override
	public ArticleDo findArticleById(int id) {
		try(final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			final Query<ArticleDo> query= session.createQuery("From ArticleDo where id = :idParam", ArticleDo.class);
			// on initialise le paramètre
			query.setParameter("idParam", id);
			// regarder la Javadoc de Optional 
			final java.util.Optional<ArticleDo> articleDo = query.uniqueResultOptional();

			session.flush();
			transaction.commit();
			//suite de la feature Optional de Java 8
			return articleDo.orElse(null);
		}catch(final HibernateException hibernateException){
			// on peut catcher des HibernateException 
			hibernateException.printStackTrace();
			return null;
		}
		// return null; écrase l'article ?
	}

	@Override
	public ArticleDo createArticle(ArticleDo article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo updateArticle(final ArticleDo articleDo, final int id) {
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
	public boolean deleteArticle(final int id) {
		try (final Session session = sessionFactory.getCurrentSession()) {
			//sans auto-commit, on doit créer une transaction
			final Transaction transaction = session.beginTransaction();

			//delete avec query 
			final Query<?> query = session.createQuery("delete from ArticleDo where id = :idArticleDo");
			query.setParameter("idArticleDo", id);
			final int result = query.executeUpdate();

			//delete sans query
			//				final ArticleDo articleDo = session.load(ArticleDo.class, idArticleDo);
			//				session.delete(articleDo);

			session.flush();
			transaction.commit();
			
			if (result ==1 ) {
				return true;
			}

			}catch (final HibernateException | EntityNotFoundException exception){
			// on peut catcher des HibernateExceptin ou des EntityNotFoundException pour le session.delete
			exception.printStackTrace();
		}
		return false;
	}

}
