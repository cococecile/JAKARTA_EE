package poei.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poei.presentation.bean.ArticleDto;
import poei.service.imp.ArticleService;

@Controller
public class ArticleController {
	
	  @Autowired
	    ArticleService articleService;

  

    @RequestMapping("/articleCreate")
    public String showCreateArticlePage(Model model) {
        model.addAttribute("command", new ArticleDto());
        return "articlecreate";
    }
    
    @RequestMapping(value = "/articleCreate", method = RequestMethod.POST)
    public String  createArticle(@ModelAttribute("article")ArticleDto article) {
        articleService.create(article);
        return "redirect:/articleDetail";
    }

    
}

