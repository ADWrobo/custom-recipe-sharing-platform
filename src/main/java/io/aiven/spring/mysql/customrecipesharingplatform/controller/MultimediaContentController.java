package io.aiven.spring.mysql.customrecipesharingplatform.controller;

import io.aiven.spring.mysql.customrecipesharingplatform.service.MultimediaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/recipes/{recipeId}/media")
public class MultimediaContentController {

    @Autowired
    private MultimediaContentService multimediaContentService;

    @PostMapping("/add")
    public ResponseEntity<Void> addMediaToRecipe(@PathVariable Long recipeId, @RequestParam("file") MultipartFile file) {
        multimediaContentService.addMedia(recipeId, file);
        return ResponseEntity.ok().build();
    }

    // Additional methods to retrieve or delete media can be implemented as needed.
}
