package io.aiven.spring.mysql.customrecipesharingplatform.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ethnicOrigin;
    private String difficulty;
    private List<String> preparationSteps;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    @OneToOne(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private MultimediaContent multimediaContent;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEthnicOrigin() { return ethnicOrigin; }
    public void setEthnicOrigin(String ethnicOrigin) { this.ethnicOrigin = ethnicOrigin; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public List<Ingredient> getIngredients() { return ingredients; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }
    public MultimediaContent getMultimediaContent() { return multimediaContent; }
    public void setMultimediaContent(MultimediaContent multimediaContent) { this.multimediaContent = multimediaContent; }
    public List<String> getPreparationSteps() { return preparationSteps; }
    public void setPreparationSteps(List<String> preparationSteps) { this.preparationSteps = preparationSteps; }
}
