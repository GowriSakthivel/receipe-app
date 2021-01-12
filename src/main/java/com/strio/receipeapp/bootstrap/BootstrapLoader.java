package com.strio.receipeapp.bootstrap;

import com.strio.receipeapp.model.*;
import com.strio.receipeapp.repository.CategoryRepository;
import com.strio.receipeapp.repository.RecipeRepository;
import com.strio.receipeapp.repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class BootstrapLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private UnitOfMeasure tblSpoon;
    private UnitOfMeasure teaSpoon;
    private UnitOfMeasure nos;
    private UnitOfMeasure dash;
    private UnitOfMeasure garnish;
    private UnitOfMeasure pint;
    private UnitOfMeasure kgs;
    private UnitOfMeasure cup;
    private UnitOfMeasure clove;
    private UnitOfMeasure serve;
    private Category american;
    private Category mexican;


    public BootstrapLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUnitOfMeasure();
        loadGuacamoleRecipeRecipe();
        loadSpicyGrilledChickenTacosRecipe();
    }

    private void loadCategory() {
        american = getValidCategory("AMERICAN");
        mexican = getValidCategory("MEXICAN");
    }

    private void loadUnitOfMeasure() {
        tblSpoon = getValidUnitOfMeasure("TableSpoon");
        teaSpoon = getValidUnitOfMeasure("TeaSpoon");
        nos = getValidUnitOfMeasure("Nos.");
        dash = getValidUnitOfMeasure("Dash");
        garnish = getValidUnitOfMeasure("Garnish");
        serve = getValidUnitOfMeasure("Serve");
        cup = getValidUnitOfMeasure("Cup");
        pint = getValidUnitOfMeasure("Pint");
        kgs = getValidUnitOfMeasure("Kg");
        clove = getValidUnitOfMeasure("Clove");
    }

    private UnitOfMeasure getValidUnitOfMeasure(String description) {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription(description);
        if (uom.isPresent())
            return uom.get();
        else throw new RuntimeException();
    }

    private Category getValidCategory(String description) {
        Optional<Category> category = categoryRepository.findByDescription(description);
        if (category.isPresent())
            return category.get();
        else throw new RuntimeException();
    }

    private void loadSpicyGrilledChickenTacosRecipe() {

        //Spicy Grilled Chicken Tacos
        //Serves 6 - 8
        //PreTime 20 mins
        //Cook Time 15 mins
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setServing(8);
        tacosRecipe.setCookTime(15);
        tacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, " +
                "oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. " +
                "Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into " +
                "the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. " +
                "As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for " +
                "a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula." +
                " Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. " +
                "Serve with lime wedges.");


        Notes notes = new Notes();
        notes.setRecipe(tacosRecipe);
        notes.setDescription("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. " +
                "I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting" +
                " through the house.");
        tacosRecipe.setNotes(notes);

        tacosRecipe.getCategories().add(american);
        tacosRecipe.getCategories().add(mexican);

        //1 lime, cut into wedges
        Ingredient lime = new Ingredient("lime, cut into wedges", BigDecimal.valueOf(1), nos, tacosRecipe);
        tacosRecipe.getIngredients().add(lime);

        //2 tablespoons ancho chili powder
        Ingredient anchoChiliPowder = new Ingredient("ancho chili powder", BigDecimal.valueOf(2), tblSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(anchoChiliPowder);

        //1 teaspoon dried oregano
        Ingredient oregano = new Ingredient("dried oregano", BigDecimal.valueOf(1), teaSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(oregano);

        //1 teaspoon dried cumin
        Ingredient cumin = new Ingredient("dried cumin", BigDecimal.valueOf(1), teaSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(cumin);

        //1 teaspoon sugar
        Ingredient sugar = new Ingredient("sugar", BigDecimal.valueOf(1), teaSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(sugar);

        //1/2 teaspoon salt
        Ingredient salt = new Ingredient("salt", BigDecimal.valueOf(1 / 2), teaSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(salt);

        //1 clove garlic, finely chopped
        Ingredient garlic = new Ingredient("clove garlic, finely chopped", BigDecimal.valueOf(1), clove, tacosRecipe);
        tacosRecipe.getIngredients().add(garlic);

        //1 tablespoon finely grated orange zest
        Ingredient orangeZest = new Ingredient("finely grated orange zest", BigDecimal.valueOf(1), tblSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(orangeZest);

        //3 tablespoons fresh-squeezed orange juice
        Ingredient orangeJuice = new Ingredient("fresh-squeezed orange juice", BigDecimal.valueOf(3), tblSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(orangeJuice);

        //2 tablespoons olive oil
        Ingredient oliveOil = new Ingredient("olive oil", BigDecimal.valueOf(2), tblSpoon, tacosRecipe);
        tacosRecipe.getIngredients().add(oliveOil);

        //4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)
        Ingredient chickenThighs = new Ingredient("skinless, boneless chicken thighs", BigDecimal.valueOf(11 / 4), kgs, tacosRecipe);
        tacosRecipe.getIngredients().add(chickenThighs);

        //8 small corn tortillas
        Ingredient tortillas = new Ingredient("small corn tortillas", BigDecimal.valueOf(8), nos, tacosRecipe);
        tacosRecipe.getIngredients().add(tortillas);

        //3 cups packed baby arugula (3 ounces)
        Ingredient arugula = new Ingredient("packed baby arugula", BigDecimal.valueOf(3), kgs, tacosRecipe);
        tacosRecipe.getIngredients().add(arugula);

        //2 medium ripe avocados, sliced
        Ingredient avocados = new Ingredient("medium ripe avocados, sliced", BigDecimal.valueOf(2), nos, tacosRecipe);
        tacosRecipe.getIngredients().add(avocados);

        //4 radishes, thinly sliced
        Ingredient radishes = new Ingredient("radishes, thinly sliced", BigDecimal.valueOf(4), nos, tacosRecipe);
        tacosRecipe.getIngredients().add(radishes);

        //1/2 pint cherry tomatoes, halved
        Ingredient tomatoes = new Ingredient("pint cherry tomatoes, halved", BigDecimal.valueOf(1/2), pint, tacosRecipe);
        tacosRecipe.getIngredients().add(tomatoes);

        //1/4 red onion, thinly sliced
        Ingredient onion = new Ingredient("red onion, thinly sliced", BigDecimal.valueOf(1/4), nos, tacosRecipe);
        tacosRecipe.getIngredients().add(onion);

        //Roughly chopped cilantro
        Ingredient cilantro = new Ingredient("Roughly chopped cilantro", BigDecimal.valueOf(1), garnish, tacosRecipe);
        tacosRecipe.getIngredients().add(cilantro);

        //1/2 cup sour cream thinned with 1/4 cup milk
        Ingredient cream = new Ingredient("cup sour cream thinned with 1/4 cup milk", BigDecimal.valueOf(1/2), cup, tacosRecipe);
        tacosRecipe.getIngredients().add(cream);

        recipeRepository.save(tacosRecipe);
        System.out.println("Recipe in bootstrap " + recipeRepository.count());
    }

    private void loadGuacamoleRecipeRecipe() {
        //Guacamole Recipe
        //Serves 2 - 4
        //PreTime 10 mins
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(10);
        guacamoleRecipe.setServing(4);
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setSource("Simply Recipes");
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half." +
                " Remove the pit. Score the inside of the avocado with a blunt knife and " +
                "scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. " +
                "(Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. " +
                "The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary " +
                "individually in their hotness. So, start with a half of one chili pepper and add " +
                "to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in " +
                "the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped " +
                "tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, \n" +
                "place plastic wrap on the surface of the guacamole and press down to cover \n" +
                "it and to prevent air reaching it. (The oxygen in the air causes oxidation which will \n" +
                "turn the guacamole brown.) Refrigerate until ready to serve");

        Notes notes = new Notes();
        notes.setDescription("The word “guacamole”, \n" +
                "and the dip, are both originally from Mexico,\n" +
                "where avocados have been cultivated for thousands of years. \n" +
                "The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");
        notes.setRecipe(guacamoleRecipe);

        guacamoleRecipe.getCategories().add(mexican);
        guacamoleRecipe.getCategories().add(american);
        guacamoleRecipe.setNotes(notes);

        //2 ripe avocados
        Ingredient avocados = new Ingredient("Ripe Avocados", BigDecimal.valueOf(2), nos, guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(avocados);

        //1/4 teaspoon of salt, more to taste
        Ingredient salt = new Ingredient("Salt", BigDecimal.valueOf(1 / 4), teaSpoon, guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(salt);

        //1 tablespoon fresh lime juice or lemon juice
        Ingredient limeJuice = new Ingredient("Fresh lime juice or lemon juice", BigDecimal.valueOf(1), tblSpoon, guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(limeJuice);

        //2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion
        Ingredient onion = new Ingredient("minced red onion or thinly sliced green onion", BigDecimal.valueOf(2), tblSpoon, guacamoleRecipe);
        onion.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(onion);

        //1-2 serrano chiles, stems and seeds removed, minced
        Ingredient chilies = new Ingredient("Serrano chilies, stems and seeds removed, minced", BigDecimal.valueOf(2), nos, guacamoleRecipe);
        chilies.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(chilies);

        //2 tablespoons cilantro (leaves and tender stems), finely chopped
        Ingredient cilantro = new Ingredient("Cilantro (leaves and tender stems), finely chopped", BigDecimal.valueOf(2), tblSpoon, guacamoleRecipe);
        cilantro.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(cilantro);

        //A dash of freshly grated black pepper
        Ingredient pepper = new Ingredient("A dash of freshly grated black pepper", BigDecimal.valueOf(1), dash, guacamoleRecipe);
        pepper.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(pepper);

        //1/2 ripe tomato, seeds and pulp removed, chopped
        Ingredient tomato = new Ingredient("Ripe tomato, seeds and pulp removed, chopped", BigDecimal.valueOf(1 / 2), nos, guacamoleRecipe);
        tomato.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(tomato);

        //Red radishes or jicama, to garnish
        Ingredient radishes = new Ingredient("Red radishes or jicama, to garnish", BigDecimal.valueOf(1), garnish, guacamoleRecipe);
        radishes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(radishes);

        //Tortilla chips, to serve
        Ingredient tortilla = new Ingredient("Tortilla chips, to serve", BigDecimal.valueOf(2), serve, guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(tortilla);

        recipeRepository.save(guacamoleRecipe);
        System.out.println("Recipe in bootstrap " + recipeRepository.count());
        System.out.println("Ingredients in bootstrap " + recipeRepository.findById(1L).get().getIngredients().size());
    }

}
