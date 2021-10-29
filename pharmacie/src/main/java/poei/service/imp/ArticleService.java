package poei.service.imp;


import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.RepositoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 * Classe Service de l'objet Article implémantant l'interface Sercice IArticleService
 * 
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ArticleService implements IArticleService {
    
}



// public class ArticleServiceImp   implements IArticleService {

//     @Autowired
//     private RepositoryType Repository;

//     @Override
//     public List<ArticleService> list() {
//         List<ArticleService> liste = new ArrayList<ArticleService>();
//         Repository.findAll().forEach(liste::add);
//         return liste;
//     }
//     @Override
//     public ArticleService findAll(articleservice){
        
//     }

//     /**
//      * Update one article
//      * 
//      * @param the article that we want to update
//      * @return the updated article or Invalid object exception
//      */

//     @Override
//     public ArticleService update(ArticleService articleservice) {

//         // TODO remove.production
//         System.out.println("update one article : " + articleservice.getTitle());
//         if (validateForm(articleservice)) {
//            return Repository.save(articleservice)
//         }
//         throw new InsertionException("invalide object");

//     }
//     @Override
//     public IArticleService findall(IArticleService ArticleService) {
//         // TODO Auto-generated method stub
//         return null;
//     }
//     @Override
//     public IArticleService update(IArticleService articleService) {
//         // TODO Auto-generated method stub
//         return null;
//     }
//     @Override
//     public String updateArticleService(String id, ArticleServiceImp articleserviceimp) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     // /**
//     //  * Update one article
//     //  *
//     //  */
//     // @Override
//     // public Long createNewArticle(ArticleService articleservice) {
//     //     System.out.println(articleService.toString());
//     //     if (validateForm(articleService)) {
//     //         System.out.println(" la méthode createNewArticle est passée");
//     //         return Repository.save(articleService).getId();
//     //     }

//     //     throw new InsertionException("invalide object");
//     // }

//     // private boolean validateForm(ArticleService article) {
//     //     return false;
//     // }

//     // /**
//     //  * Find one post
//     //  *
//     //  * @param title of the article
//     //  * @return the article
//     //  */
//     // @Override
    
    // public ArticleService findByTitle(String title) {
    //     System.out.println("Find one article : " + title);
    //     return Repository.findByTitle(title);
    // }

    // @Override
    // public ArticleService get(Long id) {
    //     return Repository.findById(id).get();
    // }

    // /**
    //  * This method updates a post from the database, changing its published
    //  * attribute to true or false. Since the post object given by front has null
    //  * fields, we must first find the full corresponding object in the database
    //  * (passing the given ID to a get method). If we do not do that, database will
    //  * reject the request because of NOT NULL constraint violation. We could also
    //  * use a PATCH method rather than PUT method to update only the desired fields,
    //  * but front send us PUT method so we have to deal with it.
    //  * 
    //  * @param id   the ID of the post that we want to update in the database, given
    //  *             by front HTTP request
    //  * @param article a article object with null attributes, except for the "published"
    //  *             attribute, which is the attribute that we want to update on the
    //  *             object in the database.
    //  * 
    //  * @throws ResourceNotFoundException if no article in the database matches the id
    //  *                                   given to us by the front.
    //  */
    // @Override
    // public void publishUnpublish(Long id, ArticleService articleservice) {
    //     ArticleService articleToUpdate = this.get(id);
    //     if (articleToUpdate != null) {
    //         articleToUpdate.setPublished(articleservice.getPublished());
    //         this.update(articleToUpdate);
    //     }
    //     throw new ResourceNotFoundException();
    // }

    // @Override
    // public ArticleService get(Long id) {
    //     return null;
    // }

    // @Override
    // public ArticleService update(ArticleService articleservice) {
    //     return null;
    // }

    // @Override
    // public Long createNewArticle(ArticleService articleService) {
    //     return null;
    // }

    // @Override
    // public ArticleService findByTitle(String title) {
    //     return null;
    // }

    // @Override
    // public String getTitle() {
    //     return null;
    // }

    // @Override
    // public Object getPublished() {
    //     return null;
    // }

    // /**
    //  * Delete one article
    //  *
    //  * @param id the Id of the article that we want to delete
    //  * 
    //  */
    // @Override

    // public void delete(Long id) {
    //     System.out.println("Delete one article : " + id);
    //     Repository.deleteById(id);

    // }


    // @Override
    // public ArticleService findall(ArticleService ArticleService) {
    //     return null;
    // }
    
    

}

