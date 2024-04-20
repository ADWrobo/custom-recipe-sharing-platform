package io.aiven.spring.mysql.customrecipesharingplatform.seeder;

import io.aiven.spring.mysql.customrecipesharingplatform.entity.Ingredient;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Recipe;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.IngredientRepository;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    // This method is for manual invocation via controller
    public void seedDatabase() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Spicy Thai Chicken");
        recipe1.setEthnicOrigin("Thai");
        recipe1.setDifficulty("Medium");
        // Initialize the list of preparation steps and add steps
            List<String> steps = new ArrayList<>();
            steps.add("Marinate the chicken in chili sauce, garlic, and soy sauce for at least 2 hours.");
        // Set the preparation steps
        recipe1.setPreparationSteps(steps);
        recipe1 = recipeRepository.save(recipe1); // Save and reassign to capture generated ID

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Chicken Breast");
        ingredient1.setQuantity("500g");
        ingredient1.setRecipe(recipe1);
        ingredientRepository.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Red Thai Curry Paste");
        ingredient2.setQuantity("3 tbsp");
        ingredient2.setRecipe(recipe1);
        ingredientRepository.save(ingredient2);

        // Repeat for other recipes and ingredients
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();  // Method can be safely reused
    }
}
