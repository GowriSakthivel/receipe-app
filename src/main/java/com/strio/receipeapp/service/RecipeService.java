package com.strio.receipeapp.service;

import com.strio.receipeapp.commads.RecipeCommand;
import com.strio.receipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    void deleteById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long id);
}
