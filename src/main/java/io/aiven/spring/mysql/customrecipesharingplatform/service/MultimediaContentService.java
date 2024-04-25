package io.aiven.spring.mysql.customrecipesharingplatform.service;

import io.aiven.spring.mysql.customrecipesharingplatform.entity.MultimediaContent;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.Recipe;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.MultimediaContentRepository;
import io.aiven.spring.mysql.customrecipesharingplatform.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class MultimediaContentService {

    @Autowired
    private MultimediaContentRepository multimediaContentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Transactional
    public MultimediaContent addMedia(Long recipeId, MultipartFile file) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path targetLocation = Path.of("media/" + fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            MultimediaContent multimedia = new MultimediaContent();
            Recipe recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + recipeId));
            multimedia.setRecipe(recipe); // Correctly associate Recipe
            multimedia.setImagePath(targetLocation.toString());
            return multimediaContentRepository.save(multimedia);
        } catch (IOException e) {
            // Handle possible exceptions (could be logging or throwing a custom exception)
            return null;
        }
    }

    public Optional<MultimediaContent> findById(Long id) {
        return multimediaContentRepository.findById(id);
    }

    @Transactional
    public boolean delete(Long id) {
        if (multimediaContentRepository.existsById(id)) {
            multimediaContentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}