package com.strio.receipeapp.service;

import com.strio.receipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
