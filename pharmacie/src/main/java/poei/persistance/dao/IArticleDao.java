package poei.persistance.dao;

import java.util.List;

import poei.persistance.bean.ArticleDo;
import poei.presentation.bean.ArticleDto;

public interface IArticleDao {

    // ArticleDo save(ArticleDo articleDo);

    ArticleDo get(String id);

    List<ArticleDto> getAllArticle();

    ArticleDo save(ArticleDo articleDo);

}
