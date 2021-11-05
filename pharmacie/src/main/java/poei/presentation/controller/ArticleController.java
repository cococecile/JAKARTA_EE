package poei.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String getHome() {
        // ...
        return "index";
    }

    @RequestMapping(path="/item", method=RequestMethod.POST)
    public String addItem() {
        // ...
        return "item";
    }

}

