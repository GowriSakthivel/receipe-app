package com.strio.receipeapp.controller;

import com.strio.receipeapp.model.Category;
import com.strio.receipeapp.model.UnitOfMeasure;
import com.strio.receipeapp.repository.CategoryRepository;
import com.strio.receipeapp.repository.UnitOfMeasureRepository;
import com.strio.receipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class indexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    public indexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){

        model.addAttribute("recipes",recipeService.getRecipes());

        Optional<Category> category = categoryRepository.findByDescription("INDIAN");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("TableSpoon");

        System.out.println("Category = " + category.get().getId());
        System.out.println("Unit of Measure = " + unitOfMeasure.get().getId());
        System.out.println("Recipes count = " + recipeService.getRecipes().size());

        return "index";
    }
}
