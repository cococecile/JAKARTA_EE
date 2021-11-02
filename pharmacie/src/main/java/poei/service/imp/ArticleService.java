package poei.service.imp;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 03e41743aa076dec6761d891336bfca3dc9321a1
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;
import poei.persistance.dao.imp.ArticleDao;
import poei.presentation.bean.ArticleDto;

=======
import poei.presentation.bean.ArticleDto;
import poei.service.IArticleService;
>>>>>>> 03e41743aa076dec6761d891336bfca3dc9321a1

/**
 * Classe Service de l'objet Article implémantant l'interface Sercice
 * IArticleService
 * 
 */

@Service
public class ArticleService implements IArticleService {
<<<<<<< HEAD


    @Autowired
	private IArticleDao articleDao;
    
	public ArticleService(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

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
		allArticles = mapToListDesArticlesDto(ArticleDao.findAllArticle());
		return allArticles;
	}


	
	private List<ArticleDto> mapToListDesArticlesDto(Object findAllArticle) {
=======

	@Override
	public List<ArticleDto> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDto update(ArticleDto articleDto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDto create(ArticleDto articleDto) {
		// TODO Auto-generated method stub
>>>>>>> 03e41743aa076dec6761d891336bfca3dc9321a1
		return null;
	}

	@Override
<<<<<<< HEAD
	public int updateArticle(String id, ArticleService articleservice) {
		ArticleDo articleDo = articleDao.get(id);
		articleDo.setDesignation(articleDo.getDesignation());
		articleDo.setDescription(articleDo.getDescription());
		articleDo.setQuantite(articleDo.getQuantite());
		final ArticleDo updatedArticle = articleDao.save(articleDo);
		return mapToArticleDto(updatedArticle).getId();
	}
=======
	public ArticleDto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
>>>>>>> 03e41743aa076dec6761d891336bfca3dc9321a1
}
