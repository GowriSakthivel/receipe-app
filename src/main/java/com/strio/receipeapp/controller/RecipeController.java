package com.strio.receipeapp.controller;

import com.strio.receipeapp.commands.RecipeCommand;
import com.strio.receipeapp.exceptions.NotFoundException;
import com.strio.receipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
public class RecipeController {

    private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String update(@PathVariable String id,  Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/delete")
    public String delete(@PathVariable String id) {
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand recipeCommand,
                               BindingResult result) {
        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError ->
                    log.error(objectError.toString()));
            return RECIPE_RECIPEFORM_URL;
        }
        RecipeCommand recipeCommand1 = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + recipeCommand1.getId() + "/show";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",exception);

        modelAndView.setViewName("404error");
        return modelAndView;
    }

}
