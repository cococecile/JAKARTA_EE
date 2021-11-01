package poei.persistance.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;

@Repository
public class ArticleDao implements IArticleDao {

	@Override
	public List<ArticleDo> findAllArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo findArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo createArticle(ArticleDo article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDo updateArticle(ArticleDo articleDo, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
