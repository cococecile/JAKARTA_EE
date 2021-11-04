package poei.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;
import poei.persistance.dao.imp.ArticleDao;
import poei.presentation.bean.ArticleDto;
import poei.service.IArticleService;

/**
 * Classe Service de l'objet Article implémantant l'interface Sercice
 * IArticleService
 * 
 */

@Service
public class ArticleService implements IArticleService {

	@Autowired
	private IArticleDao articleDao;

	/**
	 * Permet de mapper un ArticleDo ==> ArticleDto
	 * 
	 * @param ArticleDo
	 * @return
	 */
	private ArticleDto mapToArticleDto(ArticleDo ArticleDo) {
		ArticleDto ArticleDto = new ArticleDto();
		if (ArticleDo == null) {
			return null;
		}
		ArticleDto.setId(ArticleDo.getId());
		ArticleDto.setDesignation(ArticleDo.getDesignation());
		ArticleDto.setDescription(ArticleDo.getDescription());
		return ArticleDto;
	}

	@Override
	public List<ArticleDto> getAllArticle() {
		List<ArticleDto> allArticles = new ArrayList<ArticleDto>();
		allArticles = mapToListDesArticlesDto(articleDao.findAllArticle());
		return allArticles;
	}

	private List<ArticleDto> mapToListDesArticlesDto(List<ArticleDo> findAllArticles) {
		return null;
	}

	@Override
	public ArticleDto create(ArticleDto articleDto) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public ArticleDto updateArticle(ArticleDto articleDto, int id) {

		ArticleDo articleDo = articleDao.findArticleById(id);
		if (null != articleDo) {
			articleDo.setDesignation(articleDo.getDesignation());
			articleDo.setDescription(articleDo.getDescription());
			articleDo.setQuantite(articleDo.getQuantite());
			final ArticleDo updatedArticle = articleDao.updateArticle(articleDo, id);
			return mapToArticleDto(updatedArticle);

		}

		return null;
	}

	@Override
	public boolean deleteArticle(final int id) {
		// on va récupérer l'article par l'id dans une variable
		final ArticleDto articleDto = getById(id);
		// si l'article n'est pas vide alors
		if (articleDto != null) {
			// le résultat selon le statut de l'article sera de supprimer l'article ciblé par l'id au DAO.
			boolean result = articleDao.deleteArticle(id);
			// retourner le résultat ( supprimer )
			return result;
		}
		// ou rien // 
		return false;

	}

	@Override
	public ArticleDto getById(int id) {
		// on va récupérer l'id dans une variable
		final ArticleDto ArticleDto = getById(id);
		if (ArticleDto == null){
			return null;
		}
		else{
			return ArticleDto;
		}
	}

}
