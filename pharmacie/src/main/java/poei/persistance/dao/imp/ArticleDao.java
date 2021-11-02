package poei.persistance.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;
import poei.presentation.bean.ArticleDto;

public class ArticleDao implements IArticleDao{

    private static SessionFactory sessionFactory;
    

    public static  List<ArticleDo> findAllArticles() {
        try (final Session session = sessionFactory.getCurrentSession()) {
			final Transaction transaction = session.beginTransaction();
			String req = "From Article";

			final Query <ArticleDo> query = session.createQuery(req, ArticleDo.class);
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
			return new ArticleDo() ;

			// On gère l'exception
		} catch (final HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
		return new ArticleDo() ;
		
    }


	@Override
	public ArticleDo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ArticleDto> getAllArticle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArticleDo save(ArticleDo articleDo) {
		// TODO Auto-generated method stub
		return null;
	}
    }



    
