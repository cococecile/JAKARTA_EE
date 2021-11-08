package poei.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.ArticleDto;
import poei.service.imp.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;

	/**
	 * Permet de recuperer la liste des articles pour la jsp
	 * 
	 * @param model
	 * @return redirection vers la jsp articleList
	 */
	@RequestMapping("/articlesList")
	public ModelAndView articlesList(Model model) {
		List<ArticleDto> articles = articleService.getAllArticle();
		model.addAttribute("articles", articles);
		return new ModelAndView("articlesList");
	}

	/**
	 * Permet de recuperer un article 
	 * 
	 * @return redirection vers la jsp articleDetail
	 */
	@RequestMapping("/articleDetail/{id}")
	public ModelAndView articleDétail(@PathVariable int id, Model model) {

		model.addAttribute("article", articleService.getById(id));

		return new ModelAndView("articleDetail");
	}

	/**
	 * Affiche le formulaire de creation d'un article
	 * 
	 * @param model
	 * @return redirection vers le fomulaire de création
	 */
	@RequestMapping("/articleCreate")
	public String showCreateArticlePage(Model model) {
		model.addAttribute("article", new ArticleDto());
		return "articleCreate";
	}

	/**
	 * Affiche le formulaire d'édition d'un article
	 * 
	 * @param id
	 * @param model
	 * @return redirection vers le fomulaire d'edition
	 */
	@RequestMapping(value = "/articleUpdate/{id}")
	public String showUpdateArticlePage(@PathVariable int id, Model model) {

		model.addAttribute("article", articleService.getById(id));
		return "articleUpdate";
	}

	/**
	 * Permet de creer un article
	 * 
	 * @param article
	 * @return redirection vers la jsp articleList si creation ok sinon vers le
	 *         formulaire de creation
	 */
	@RequestMapping(value = "/articleCreate", method = RequestMethod.POST)
	public String createArticle(@ModelAttribute("article") ArticleDto article) {
		ArticleDto newArticle = articleService.create(article);
		if (null != newArticle) {
			return "redirect:/articlesList";

		}
		return "redirect:/articleCreate";
	}

	/**
	 * Permet d'editer un article
	 * 
	 * @param article
	 * @return redirection vers la jsp articleList si edition OK sinon vers le
	 *         formulaire d'édition
	 */
	@RequestMapping(value = "/articleUpdate", method = RequestMethod.POST)
	public String updateArticle(@ModelAttribute("article") ArticleDto article) {
		ArticleDto updatedArticle = articleService.updateArticle(article, article.getId());
		if (updatedArticle != new ArticleDto()) {
			return "redirect:/articlesList";

		}
		return "redirect:/articleUpdate";
	}

	/**
	 * Permet supprimer un article
	 * 
	 * @param article
	 * @return redirection vers la jsp articleList
	 */
	@RequestMapping(value = "/articleDelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		articleService.deleteArticle(id);

		return "redirect:/articlesList";

	}
}
