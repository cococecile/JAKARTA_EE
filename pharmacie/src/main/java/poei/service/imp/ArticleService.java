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
	public static List<ArticleDto> getAllArticle() {
		List<ArticleDto> allArticles = new ArrayList<ArticleDto>();
		allArticles = mapToListDesArticlesDto(ArticleDao.findAllArticles());
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
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArticleDto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
