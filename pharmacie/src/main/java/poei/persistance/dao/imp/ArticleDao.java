package poei.persistance.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import poei.persistance.bean.ArticleDo;
import poei.persistance.dao.IArticleDao;
import poei.presentation.bean.ArticleDto;

@Repository
public class ArticleDao implements IArticleDao {

    public static Object findAllArticle() {
        return null;
    }

    @Override
    public ArticleDo get(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ArticleDto> getAllArticle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArticleDo save(ArticleDo articleDo) {
        // TODO Auto-generated method stub
        return null;
    }
}
