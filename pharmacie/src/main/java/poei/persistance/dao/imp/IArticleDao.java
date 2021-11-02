package poei.persistance.dao.imp;

import java.util.List;


import org.springframework.stereotype.Repository;


import poei.persistance.bean.ArticleDo;


@Repository

public interface IArticleDao  {
    
    List<ArticleDo> findAllArticles();

}

