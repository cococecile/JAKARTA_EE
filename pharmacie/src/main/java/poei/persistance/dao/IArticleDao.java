package poei.persistance.dao;

import java.util.List;

import poei.persistance.bean.ArticleDo;

/**
 * Interface de UserDao
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
	void delete(final int id);
	
}
