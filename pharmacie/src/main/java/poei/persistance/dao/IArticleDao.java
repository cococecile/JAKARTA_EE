package poei.persistance.dao;

import java.util.List;

import poei.persistance.bean.ArticleDo;


/**
 * Interface de ArticleDao
 * 
 * @author Apprenant
 *
 */
public interface IArticleDao {
	
	
	/**
	 * Permet de retourner la liste de tous les articles
	 * @return
	 */
	List<ArticleDo> findAllArticle();
	
	/**
	 * Permet de chercher un article à partir de son id
	 * @param id
	 * @return
	 */
	ArticleDo findArticleById(final int id);
	
	
	/**
	 * Permet de creer un article
	 * @param article
	 * @return
	 */
	ArticleDo createArticle(final ArticleDo article);
	
	/**
	 * Permet de mettre à jour un article
	 * @return
	 */
	ArticleDo updateArticle(final ArticleDo articleDo, final int id);
	
	/**
	 * Permet de supprimer un article à partir de son id
	 * @param id
	 */
	@Override
		public boolean deleteArticleDo(final int idArticleDo) {
			try (final Session session = sessionFactory.currentSession()) {
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
				
				return int result;

				}catch (final HibernateException | EntityNotFoundException exception){
				// on peut catcher des HibernateExceptin ou des EntityNotFoundException pour le session.delete
				exception.printStackTrace();
			}
			return false;
		}

	
}
