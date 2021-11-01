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
	
	
	List<ArticleDo> findAllArticle();
	
	ArticleDo findArticleById(final int id);
}
