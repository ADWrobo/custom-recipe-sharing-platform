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
        // Recipe 1: Spicy Thai Chicken
        Recipe recipe1 = new Recipe();
        recipe1.setName("Spicy Thai Chicken");
        recipe1.setEthnicOrigin("Thai");
        recipe1.setDifficulty("Medium");
        // Initialize the list of preparation steps and add steps
        // TODO: This returns an error when we try to add multiple steps to the array. Why?
            List<String> steps = new ArrayList<>();
            steps.add("Marinate the chicken in chili sauce, garlic, and soy sauce for at least 2 hours.");
        // Set the preparation steps
        recipe1.setPreparationSteps(steps);
        recipe1 = recipeRepository.save(recipe1); // Save and reassign to capture generated ID

        // Recipe 2: Italian Mushroom Risotto
        Recipe recipe2 = new Recipe();
        recipe2.setName("Italian Mushroom Risotto");
        recipe2.setEthnicOrigin("Italian");
        recipe2.setDifficulty("High");
        List<String> steps2 = new ArrayList<>();
        steps2.add("Saute onions and garlic in olive oil until translucent.");
//        steps2.add("Add rice and cook until slightly toasted.");
//        steps2.add("Gradually add chicken broth and stir until the rice is fully cooked.");
//        steps2.add("Stir in sliced mushrooms and Parmesan cheese.");
        recipe2.setPreparationSteps(steps2);
        recipe2 = recipeRepository.save(recipe2);

        // Recipe 3: French Onion Soup
        Recipe recipe3 = new Recipe();
        recipe3.setName("French Onion Soup");
        recipe3.setEthnicOrigin("French");
        recipe3.setDifficulty("Medium");
        List<String> steps3 = new ArrayList<>();
        steps3.add("Caramelize onions in a large pot.");
//        steps3.add("Add beef broth and simmer for 30 minutes.");
//        steps3.add("Serve with toasted bread topped with melted Gruyere cheese.");
        recipe3.setPreparationSteps(steps3);
        recipe3 = recipeRepository.save(recipe3);

        // Recipe 4: Mexican Tacos
        Recipe recipe4 = new Recipe();
        recipe4.setName("Mexican Tacos");
        recipe4.setEthnicOrigin("Mexican");
        recipe4.setDifficulty("Easy");
        List<String> steps4 = new ArrayList<>();
        steps4.add("Cook ground beef with taco seasoning.");
//        steps4.add("Serve in corn tortillas with chopped onions, cilantro, and salsa.");
        recipe4.setPreparationSteps(steps4);
        recipe4 = recipeRepository.save(recipe4);

        // Recipe 5: Indian Butter Chicken
        Recipe recipe5 = new Recipe();
        recipe5.setName("Indian Butter Chicken");
        recipe5.setEthnicOrigin("Indian");
        recipe5.setDifficulty("Medium");
        List<String> steps5 = new ArrayList<>();
        steps5.add("Marinate chicken in a mixture of yogurt and spices overnight.");
//        steps5.add("Cook the chicken in a sauce made from tomatoes, butter, and cream.");
        recipe5.setPreparationSteps(steps5);
        recipe5 = recipeRepository.save(recipe5);

        // Recipe 6: Japanese Sushi Rolls
        Recipe recipe6 = new Recipe();
        recipe6.setName("Japanese Sushi Rolls");
        recipe6.setEthnicOrigin("Japanese");
        recipe6.setDifficulty("High");
        List<String> steps6 = new ArrayList<>();
        steps6.add("Prepare sushi rice and let it cool.");
//        steps6.add("Lay out nori, spread rice on top, and place fillings like fish and vegetables.");
//        steps6.add("Roll tightly and slice into pieces.");
        recipe6.setPreparationSteps(steps6);
        recipe6 = recipeRepository.save(recipe6);

        // Recipe 7: Spanish Paella
        Recipe recipe7 = new Recipe();
        recipe7.setName("Spanish Paella");
        recipe7.setEthnicOrigin("Spanish");
        recipe7.setDifficulty("Medium");
        List<String> steps7 = new ArrayList<>();
        steps7.add("Cook saffron rice with chicken, rabbit, and seafood.");
//        steps7.add("Add peas, peppers, and cook until the rice is tender.");
        recipe7.setPreparationSteps(steps7);
        recipe7 = recipeRepository.save(recipe7);

        // Recipe 8: Moroccan Couscous
        Recipe recipe8 = new Recipe();
        recipe8.setName("Moroccan Couscous");
        recipe8.setEthnicOrigin("Moroccan");
        recipe8.setDifficulty("Medium");
        List<String> steps8 = new ArrayList<>();
        steps8.add("Steam couscous until fluffy.");
//        steps8.add("Serve with stewed vegetables and spiced lamb.");
        recipe8.setPreparationSteps(steps8);
        recipe8 = recipeRepository.save(recipe8);

        // Recipe 9: Greek Moussaka
        Recipe recipe9 = new Recipe();
        recipe9.setName("Greek Moussaka");
        recipe9.setEthnicOrigin("Greek");
        recipe9.setDifficulty("High");
        List<String> steps9 = new ArrayList<>();
        steps9.add("Layer sautéed eggplant with spiced ground lamb and béchamel sauce.");
//        steps9.add("Bake until golden and bubbly.");
        recipe9.setPreparationSteps(steps9);
        recipe9 = recipeRepository.save(recipe9);

        // Recipe 10: English Fish and Chips
        Recipe recipe10 = new Recipe();
        recipe10.setName("English Fish and Chips");
        recipe10.setEthnicOrigin("English");
        recipe10.setDifficulty("Easy");
        List<String> steps10 = new ArrayList<>();
        steps10.add("Batter and fry cod until golden.");
//        steps10.add("Serve with fries and tartar sauce.");
        recipe10.setPreparationSteps(steps10);
        recipe10 = recipeRepository.save(recipe10);

        // Recipe 11: Vietnamese Pho
        Recipe recipe11 = new Recipe();
        recipe11.setName("Vietnamese Pho");
        recipe11.setEthnicOrigin("Vietnamese");
        recipe11.setDifficulty("Medium");
        List<String> steps11 = new ArrayList<>();
        steps11.add("Simmer beef bones to make broth.");
//        steps11.add("Serve with rice noodles, herbs, and thinly sliced beef.");
        recipe11.setPreparationSteps(steps11);
        recipe11 = recipeRepository.save(recipe11);

        // Ingredients for Recipe 1: Spicy Thai Chicken
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

        // Ingredients for Recipe 2: Italian Mushroom Risotto
        Ingredient ingredient21 = new Ingredient();
        ingredient21.setName("Arborio Rice");
        ingredient21.setQuantity("200g");
        ingredient21.setRecipe(recipe2);
        ingredientRepository.save(ingredient21);

        Ingredient ingredient22 = new Ingredient();
        ingredient22.setName("Mushrooms");
        ingredient22.setQuantity("150g");
        ingredient22.setRecipe(recipe2);
        ingredientRepository.save(ingredient22);

        // Ingredients for Recipe 3: French Onion Soup
        Ingredient ingredient31 = new Ingredient();
        ingredient31.setName("Onions");
        ingredient31.setQuantity("500g");
        ingredient31.setRecipe(recipe3);
        ingredientRepository.save(ingredient31);

        Ingredient ingredient32 = new Ingredient();
        ingredient32.setName("Beef Broth");
        ingredient32.setQuantity("1 liter");
        ingredient32.setRecipe(recipe3);
        ingredientRepository.save(ingredient32);

        // Ingredients for Recipe 4: Mexican Tacos
        Ingredient ingredient41 = new Ingredient();
        ingredient41.setName("Ground Beef");
        ingredient41.setQuantity("400g");
        ingredient41.setRecipe(recipe4);
        ingredientRepository.save(ingredient41);

        Ingredient ingredient42 = new Ingredient();
        ingredient42.setName("Corn Tortillas");
        ingredient42.setQuantity("8 pcs");
        ingredient42.setRecipe(recipe4);
        ingredientRepository.save(ingredient42);

        // Ingredients for Recipe 5: Indian Butter Chicken
        Ingredient ingredient51 = new Ingredient();
        ingredient51.setName("Chicken Thighs");
        ingredient51.setQuantity("600g");
        ingredient51.setRecipe(recipe5);
        ingredientRepository.save(ingredient51);

        Ingredient ingredient52 = new Ingredient();
        ingredient52.setName("Cream");
        ingredient52.setQuantity("250ml");
        ingredient52.setRecipe(recipe5);
        ingredientRepository.save(ingredient52);

        // Ingredients for Recipe 6: Japanese Sushi Rolls
        Ingredient ingredient61 = new Ingredient();
        ingredient61.setName("Sushi Rice");
        ingredient61.setQuantity("300g");
        ingredient61.setRecipe(recipe6);
        ingredientRepository.save(ingredient61);

        Ingredient ingredient62 = new Ingredient();
        ingredient62.setName("Nori Sheets");
        ingredient62.setQuantity("5 pcs");
        ingredient62.setRecipe(recipe6);
        ingredientRepository.save(ingredient62);

        // Ingredients for Recipe 7: Spanish Paella
        Ingredient ingredient71 = new Ingredient();
        ingredient71.setName("Paella Rice");
        ingredient71.setQuantity("350g");
        ingredient71.setRecipe(recipe7);
        ingredientRepository.save(ingredient71);

        Ingredient ingredient72 = new Ingredient();
        ingredient72.setName("Mixed Seafood");
        ingredient72.setQuantity("400g");
        ingredient72.setRecipe(recipe7);
        ingredientRepository.save(ingredient72);

        // Ingredients for Recipe 8: Moroccan Couscous
        Ingredient ingredient81 = new Ingredient();
        ingredient81.setName("Couscous");
        ingredient81.setQuantity("300g");
        ingredient81.setRecipe(recipe8);
        ingredientRepository.save(ingredient81);

        Ingredient ingredient82 = new Ingredient();
        ingredient82.setName("Lamb Meat");
        ingredient82.setQuantity("500g");
        ingredient82.setRecipe(recipe8);
        ingredientRepository.save(ingredient82);

        // Ingredients for Recipe 9: Greek Moussaka
        Ingredient ingredient91 = new Ingredient();
        ingredient91.setName("Eggplant");
        ingredient91.setQuantity("3 pcs");
        ingredient91.setRecipe(recipe9);
        ingredientRepository.save(ingredient91);

        Ingredient ingredient92 = new Ingredient();
        ingredient92.setName("Ground Lamb");
        ingredient92.setQuantity("500g");
        ingredient92.setRecipe(recipe9);
        ingredientRepository.save(ingredient92);

        // Ingredients for Recipe 10: English Fish and Chips
        Ingredient ingredient101 = new Ingredient();
        ingredient101.setName("Cod Fillets");
        ingredient101.setQuantity("4 pcs");
        ingredient101.setRecipe(recipe10);
        ingredientRepository.save(ingredient101);

        Ingredient ingredient102 = new Ingredient();
        ingredient102.setName("Potatoes");
        ingredient102.setQuantity("800g");
        ingredient102.setRecipe(recipe10);
        ingredientRepository.save(ingredient102);

        // Ingredients for Recipe 11: Vietnamese Pho
        Ingredient ingredient111 = new Ingredient();
        ingredient111.setName("Beef Bones");
        ingredient111.setQuantity("1 kg");
        ingredient111.setRecipe(recipe11);
        ingredientRepository.save(ingredient111);

        Ingredient ingredient112 = new Ingredient();
        ingredient112.setName("Rice Noodles");
        ingredient112.setQuantity("400g");
        ingredient112.setRecipe(recipe11);
        ingredientRepository.save(ingredient112);
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();  // Method can be safely reused
    }
}
