package com.strio.receipeapp.service;

import com.strio.receipeapp.commands.IngredientCommand;
import com.strio.receipeapp.converters.IngredientCommandToIngredient;
import com.strio.receipeapp.converters.IngredientToIngredientCommand;
import com.strio.receipeapp.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.strio.receipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.strio.receipeapp.model.Ingredient;
import com.strio.receipeapp.model.Recipe;
import com.strio.receipeapp.repository.RecipeRepository;
import com.strio.receipeapp.repository.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    //init converters
    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository, unitOfMeasureRepository, ingredientCommandToIngredient);
    }

    @Test
    void testFindByRecipeIdAndIngredientId() {
        //given
        Optional<Recipe> recipeOptional = getOptionalRecipeWithThreeIngredients();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //when
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    void saveIngredientCommand() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        recipe.addIngredient(ingredient1);

        when(recipeRepository.save(any())).thenReturn(recipe);

        //then
        Recipe savedRecipe = recipeRepository.save(recipe);

        //when
        assertEquals(Long.valueOf(1L), savedRecipe.getId());
        verify(recipeRepository, times(1)).save(any());
    }

    @Test
    void deleteById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(2L);
        recipe.addIngredient(ingredient1);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        ingredientService.deleteById(1L,2L);

       verify(recipeRepository,times(1)).findById(anyLong());
       verify(recipeRepository,times(1)).save(any(Recipe.class));
    }

    Optional<Recipe> getOptionalRecipeWithThreeIngredients() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        return Optional.of(recipe);
    }
}