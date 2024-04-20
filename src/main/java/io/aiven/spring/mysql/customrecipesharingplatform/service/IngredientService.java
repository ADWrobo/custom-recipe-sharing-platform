package io.aiven.spring.mysql.customrecipesharingplatform.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Ingredient;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.IngredientRepository;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Recipe;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.RecipeRepository;
import java.util.*;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository; // Inject RecipeRepository

    public List<Ingredient> findByRecipeId(Long recipeId) {
        return ingredientRepository.findByRecipeId(recipeId);
    }

    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Transactional
    public Ingredient save(Long recipeId, Ingredient ingredient) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + recipeId));
        ingredient.setRecipe(recipe); // Correctly associate Recipe
        return ingredientRepository.save(ingredient);
    }

    @Transactional
    public boolean delete(Long id) {
        if (ingredientRepository.existsById(id)) {
            ingredientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Ingredient update(Long id, Ingredient updatedIngredient) {
        return ingredientRepository.findById(id)
                .map(ingredient -> {
                    ingredient.setName(updatedIngredient.getName());
                    ingredient.setQuantity(updatedIngredient.getQuantity());
                    return ingredientRepository.save(ingredient);
                })
                .orElse(null);
    }
}