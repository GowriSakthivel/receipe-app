package com.strio.receipeapp.controller;

import com.strio.receipeapp.model.Category;
import com.strio.receipeapp.model.UnitOfMeasure;
import com.strio.receipeapp.repository.CategoryRepository;
import com.strio.receipeapp.repository.UnitOfMeasureRepository;
import com.strio.receipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {
     private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
            this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        log.debug("In index controller class");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
