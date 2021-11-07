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
	public ArticleDto mapToArticleDto(ArticleDo articleDo) {
		ArticleDto articleDto = new ArticleDto();
		if (articleDo == null) {
			return null;
		}
		articleDto.setId(articleDo.getId());
		articleDto.setDesignation(articleDo.getDesignation());
		articleDto.setDescription(articleDo.getDescription());
		articleDto.setQuantite(articleDo.getQuantite());
		return articleDto;
	}

	/**
	 * Permet de mapper un ArticleDto ==> ArticleDo
	 * 
	 * @param articleDto
	 * @return articleDo
	 */
	public ArticleDo mapToArticleDo(ArticleDto articleDto) {
		ArticleDo articleDo = new ArticleDo();
		if (articleDto == null) {
			return null;
		}

//		if (articleDto.getId() == 0) {
//			articleDo.setId(100);
//		}else {

		articleDo.setId(articleDto.getId());
//		}
		articleDo.setDesignation(articleDto.getDesignation());
		articleDo.setDescription(articleDto.getDescription());
		articleDo.setQuantite(articleDto.getQuantite());
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
	public ArticleDto create(final ArticleDto articleDto) {
		final ArticleDo article = articleDao.createArticle(mapToArticleDo(articleDto));
		final ArticleDto newArticle = mapToArticleDto(article);
		if (null != newArticle) {
			return newArticle;

		}

		return new ArticleDto();

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
