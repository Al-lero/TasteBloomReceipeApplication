package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Data.Model.Recipe;
import com.tastebloomprototype.tastebloomapplication.Data.Repository.RecipeRepository;
import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImplementation implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public TasteBloomResponse createRecipe(RecipeRequest recipeRequest) {
        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipeRequest.getName());
        newRecipe.setIngredients(recipeRequest.getIngredients());
        newRecipe.setDescription(recipeRequest.getDescription());
        newRecipe.setInstructions(recipeRequest.getInstructions());

        Recipe savedRecipe = recipeRepository.save(newRecipe);

        return TasteBloomResponse.builder()
                .responseMessage("Recipe_Created_SuccessFully")
                .responseMessage("Recipe created Successfully")
                .build();
    }
}
