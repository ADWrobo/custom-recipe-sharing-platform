package io.aiven.spring.mysql.customrecipesharingplatform.repository;

import io.aiven.spring.mysql.customrecipesharingplatform.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(r.ethnicOrigin) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(r.difficulty) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Recipe> findByQuery(String query);
}
