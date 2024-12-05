package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Data.Model.Recipe;
import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;


import java.util.List;

public interface RecipeService {
    TasteBloomResponse createRecipe(RecipeRequest recipeRequest);
    TasteBloomResponse updateRecipe(Long id, RecipeRequest recipeRequest);
    List<Recipe> getAllRecipes();
    TasteBloomResponse delete();

}
