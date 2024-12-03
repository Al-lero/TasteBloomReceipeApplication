package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;

public interface RecipeService {
    TasteBloomResponse createRecipe(RecipeRequest recipeRequest);

}
