package poei.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import poei.presentation.bean.ArticleDto;
import poei.service.IArticleService;

/**
 * Classe Service de l'objet Article implémantant l'interface Sercice
 * IArticleService
 * 
 */

@Service
public class ArticleService implements IArticleService {

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
		return null;
	}

	@Override
	public ArticleDto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
