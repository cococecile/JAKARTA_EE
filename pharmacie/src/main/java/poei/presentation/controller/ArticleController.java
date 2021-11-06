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
import poei.presentation.bean.UserDto;
import poei.service.imp.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;

	public ModelAndView articleCreate() {
		return new ModelAndView("articleCreate");
	}

	@RequestMapping("/articlesList")
	public ModelAndView articlesList() {
		return new ModelAndView("articlesList");
	}

	@RequestMapping("/articleUpdate")
	public ModelAndView articleLUpdate() {
		return new ModelAndView("articleDétail");
	}

	@RequestMapping("/articleDétail")
	public ModelAndView articleDétail() {
		return new ModelAndView("articlesList");
	}

	@RequestMapping("/articleCreate")
	public String showCreateArticlePage(Model model) {
		model.addAttribute("command", new ArticleDto());
		return "articleCreate";
	}

	@RequestMapping(value = "/articleCreate", method = RequestMethod.POST)
	public String createArticle(@ModelAttribute("articleDto") ArticleDto article) {
		ArticleDto newarticle = articleService.create(article);
//		log.debug("request to save User : {}", user);
		return "redirect:/articlesList";
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
