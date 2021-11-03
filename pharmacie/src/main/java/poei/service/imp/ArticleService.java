package poei.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;
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
	 * @return articleDto
	 */
	public ArticleDto mapToArticleDto(ArticleDo ArticleDo) {
		ArticleDto articleDto = new ArticleDto();
		if (ArticleDo == null) {
			return null;
		}
		articleDto.setId(ArticleDo.getId());
		articleDto.setDesignation(ArticleDo.getDesignation());
		articleDto.setDescription(ArticleDo.getDescription());
		return articleDto;
	}

	/**
	 * Permet de mapper un ArticleDto ==> ArticleDo
	 * 
	 * @param articleDto
	 * @return articleDo
	 */
	public ArticleDo mapToArticleDto(ArticleDto articleDto) {
		ArticleDo articleDo = new ArticleDo();
		if (articleDto == null) {
			return null;
		}
		articleDo.setId(articleDto.getId());
		articleDo.setDesignation(articleDto.getDesignation());
		articleDo.setDescription(articleDto.getDescription());
		return articleDo;
	}

	/**
	 * Permet de mapper une listeArticleDo ==> listeArticleDto
	 * 
	 * @param listeArticleDo
	 * @return listeArticleDto
	 */
	public List<ArticleDto> mapToListDesArticlesDto(List<ArticleDo> listeArticleDo) {

		List<ArticleDto> listeArticleDto = new ArrayList<ArticleDto>();
		for (ArticleDo articleDo : listeArticleDo) {
			listeArticleDto.add(mapToArticleDto(articleDo));

		}
		return listeArticleDto;
	}

	@Override
	public List<ArticleDto> getAllArticle() {
		List<ArticleDto> allArticles = new ArrayList<ArticleDto>();
		allArticles = mapToListDesArticlesDto(articleDao.findAllArticle());
		return allArticles;
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
