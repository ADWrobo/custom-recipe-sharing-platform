package io.aiven.spring.mysql.customrecipesharingplatform.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import io.aiven.spring.mysql.customrecipesharingplatform.service.RecipeService;

@Controller
public class MainApplicationController {

    @Autowired
    private RecipeService recipeService;

    /**
     * Route to display the search page.
     */
    @GetMapping("/")
    public String showSearchPage() {
        return "search";  // Name of the Thymeleaf template for the search page
    }

    /**
     * Route to perform the search and display the results.
     */
    @GetMapping("/search")
    public String searchRecipes(@RequestParam String query, Model model) {
        model.addAttribute("recipes", recipeService.searchByQuery(query));
        return "search";  // Reuse the search page to show results
    }

    /**
     * Route to display a specific recipe's details.
     */
    @GetMapping("/recipe/{id}")
    public String showRecipeDetails(@PathVariable Long id, Model model) {
        recipeService.findById(id).ifPresent(recipe -> model.addAttribute("recipe", recipe));
        return "recipe";  // Name of the template for the recipe details
    }
}
