package com.tastebloomprototype.tastebloomapplication.controller;

import com.tastebloomprototype.tastebloomapplication.Data.Model.Recipe;
import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
import com.tastebloomprototype.tastebloomapplication.MealType;
import com.tastebloomprototype.tastebloomapplication.Service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/createRecipe")
    public TasteBloomResponse createRecipe(@Valid @RequestBody RecipeRequest recipeRequest) {
        return recipeService.createRecipe(recipeRequest);
    }

    @PutMapping("/update/{id}")
    public TasteBloomResponse updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeRequest recipeRequest) {
        return recipeService.updateRecipe(id, recipeRequest);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();

    }

    @DeleteMapping
    public TasteBloomResponse delete() {
        return recipeService.delete();
    }
}
