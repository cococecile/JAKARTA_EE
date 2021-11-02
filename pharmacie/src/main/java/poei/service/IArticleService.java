package poei.service;

import java.util.List;

import poei.presentation.bean.ArticleDto;
import poei.service.imp.ArticleService;

/**
 * @author Apprenant
 *
 */
public interface IArticleService {

	/**
	 * Permet de retouner la liste de tous les articles
	 * 
	 * @return articlesListe
	 */
	List<ArticleDto> findall();

	/**
	 * Permet de mettre à jour un article
	 * 
	 * @param articleDto, id
	 * @return
	 */
	ArticleDto update(ArticleDto articleDto, int id);
	
	/**
	 * Permet de creer un article
	 * 
	 * @param articleDto
	 * @return article
	 */
	ArticleDto create(ArticleDto articleDto);
	
	/**
	 * Permet de chercher un article à partir de son id
	 * @param id
	 * @return article
	 */
	ArticleDto getById(int id);
	
	/**
	 * Permet de supprimer un article à partie de son id
	 * 
	 * @param id
	 */
	void delete(int id);

	List<ArticleDto> getAllArticle();

	int updateArticle(String id, ArticleService articleservice);
	
	

}
