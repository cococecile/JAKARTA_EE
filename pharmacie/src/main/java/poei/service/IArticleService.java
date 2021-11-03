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
	List<ArticleDto> getAllArticle();
	/**
	 * Permet de mettre à jour un article
	 * 
	 * @param articleDto, id
	 * @return
	 */
	ArticleDto updateArticle(final ArticleDto articleDto, final int id);
	
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
	@Override
	// récupère le DAO de persistance pour effacer l'article si résult //
	// boolean ArticleDto soit article soit pas article //
	// final: nous n'allons pas modifier 
	// supprimer par l'id

	public boolean delete(final int id) {
		// on va récupérer l'article par l'id dans une variable
		final ArticleDto articleDto = getById(id);
		// si l'article n'est pas vide alors
		if (articleDto != null) {
			// le résultat selon le statut de l'article sera de supprimer l'article ciblé par l'id au DAO.
			boolean result = articleDao.delete(id);
			// retourner le résultat ( supprimer )
			return result;
		}
		// ou rien // 
		return false;
	}


	

	
	
	

}
