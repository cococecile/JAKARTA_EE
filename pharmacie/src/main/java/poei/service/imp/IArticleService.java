package poei.service.imp;

import java.util.List;

import poei.presentation.bean.ArticleDto;

/**
 * Interface IArticleService des méthodes métiers de la gestion des Articles
 *
 */

public interface IArticleService {

	/**
	 * Permet de retouner la liste de tous les articles
	 * 
	 * @return allArticles
	 */
	List<ArticleDto> getAllArticle();

		/**
	 * Permet de mettre à jour un article à partir de son id
	 * 
	 * @param Designation
	 * @param postDto
	 * @return id
	 */
	int updateArticle(String Designation, ArticleDto articleDto);
        
	}
