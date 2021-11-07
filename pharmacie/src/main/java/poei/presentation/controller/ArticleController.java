package poei.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poei.presentation.bean.ArticleDto;
import poei.service.imp.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;



	@RequestMapping("/articlesList")
	public ModelAndView articlesList(Model model) {
		List<ArticleDto> articles = articleService.getAllArticle();
		model.addAttribute("articles", articles);
		return new ModelAndView("articlesList");
	}

	@RequestMapping("/articleUpdate")
	public String showArticleUpdate(@RequestParam("id") int id, Model model) {
		final ArticleDto article = articleService.getById(id);
		model.addAttribute("article", article);
		return "articleUpdate";
	}

	@RequestMapping("/articleDétail")
	public ModelAndView articleDétail() {
		return new ModelAndView("articlesList");
	}

	@RequestMapping("/articleCreate")
	public String showCreateArticlePage(Model model) {
		model.addAttribute("article", new ArticleDto());
		return "articleCreate";
	}

	@RequestMapping(value = "/articleCreate", method = RequestMethod.POST)
	public String createArticle(@ModelAttribute("article") ArticleDto article) {
		ArticleDto newArticle = articleService.create(article);
		if (null != newArticle) {
			return "redirect:/articlesList";
			
		}
//		log.debug("request to save User : {}", user);
		return "redirect:/articleCreate";
	}

	@RequestMapping(value = "/articleUpdate/{id}")
	public String showUpdateArticlePage(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("command", articleService.getById(id));
		return "articleUpdate";
	}

	@RequestMapping(value = "/articleUpdate/{id}", method = RequestMethod.POST)
	public String updateArticle(@PathVariable int id, @ModelAttribute("article") ArticleDto article) {
		articleService.updateArticle(article, id);
		return "redirect:/articleDétail";
	}

}
