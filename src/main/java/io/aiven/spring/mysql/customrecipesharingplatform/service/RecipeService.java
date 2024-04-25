package io.aiven.spring.mysql.customrecipesharingplatform.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Recipe;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.RecipeRepository;
import java.util.*;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> searchByQuery(String query) {
        return recipeRepository.findByQuery(query);
    }

    @Transactional
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Transactional
    public boolean delete(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Recipe update(Long id, Recipe updatedRecipe) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setName(updatedRecipe.getName());
                    recipe.setEthnicOrigin(updatedRecipe.getEthnicOrigin());
                    recipe.setDifficulty(updatedRecipe.getDifficulty());
                    recipe.setIngredients(updatedRecipe.getIngredients());
                    recipe.setMultimediaContent(updatedRecipe.getMultimediaContent());
                    return recipeRepository.save(recipe);
                })
                .orElse(null);
    }
}
