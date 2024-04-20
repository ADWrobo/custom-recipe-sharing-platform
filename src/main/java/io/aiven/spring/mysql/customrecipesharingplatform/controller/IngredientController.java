package io.aiven.spring.mysql.customrecipesharingplatform.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Ingredient;
import io.aiven.spring.mysql.customrecipesharingplatform.service.IngredientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes/{recipeId}/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> getIngredientsByRecipe(@PathVariable Long recipeId) {
        List<Ingredient> ingredients = ingredientService.findByRecipeId(recipeId);
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        Optional<Ingredient> ingredient = ingredientService.findById(id);
        if (ingredient != null) {
            return (ResponseEntity<Ingredient>) ResponseEntity.ok();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Ingredient> addIngredientToRecipe(@PathVariable Long recipeId, @RequestBody Ingredient ingredient) {
        Ingredient newIngredient = ingredientService.save(recipeId, ingredient);
        return ResponseEntity.ok(newIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientDetails) {
        Ingredient updatedIngredient = ingredientService.update(id, ingredientDetails);
        if (updatedIngredient != null) {
            return ResponseEntity.ok(updatedIngredient);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        boolean deleted = ingredientService.delete(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
