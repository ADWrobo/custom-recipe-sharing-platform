package io.aiven.spring.mysql.customrecipesharingplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Ingredient;
import java.util.*;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long recipeId);
}
