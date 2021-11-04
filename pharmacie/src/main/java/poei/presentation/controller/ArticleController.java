package poei.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import poei.presentation.bean.ArticleDto;
import poei.service.IArticleService;

@Controller
public class ArticleController {
	
	@Autowired
    private IArticleService service;

    @GetMapping
    public String showAllArticles(Model model) {
        model.addAttribute("articlesList", service.getAllArticle());
        return "articlesList";
    }

    @GetMapping("/articleCreate")
    public String showArticleCreationForm(Model model) {
        model.addAttribute("articleList", new ArticleDto());
        return "articleCreate";
    }

    @PostMapping(value = "/articleCreate", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewArticle(@ModelAttribute ArticleDto articledto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "articleDétail";
        }
        service.create(articledto);
        model.addAttribute("articlesList", service.getAllArticle());
        return "articleList";
    }

    @PostMapping("/{id}/articleUpdate")
    public String updateArticle(@PathVariable int id, @ModelAttribute ArticleDto articleDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "articleDétail";
        }
        model.addAttribute("articleDétail", service.getAllArticle());
        return "articlesList";
    }

}
  

