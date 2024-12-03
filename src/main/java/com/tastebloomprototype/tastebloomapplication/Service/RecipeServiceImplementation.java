package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Data.Model.Recipe;
import com.tastebloomprototype.tastebloomapplication.Data.Repository.RecipeRepository;
import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
import com.tastebloomprototype.tastebloomapplication.MealType;
import com.tastebloomprototype.tastebloomapplication.utils.TasteBloomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImplementation implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    public TasteBloomResponse createRecipe(RecipeRequest recipeRequest) {
        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipeRequest.getName());
        newRecipe.setIngredients(recipeRequest.getIngredients());
        newRecipe.setDescription(recipeRequest.getDescription());
        newRecipe.setInstructions(recipeRequest.getInstructions());
        newRecipe.setMealType(recipeRequest.getMealType());
        Recipe savedRecipe = recipeRepository.save(newRecipe);

        return TasteBloomResponse.builder()
                .responseCode(TasteBloomUtils.Recipe_Created_Code)
                .responseMessage(TasteBloomUtils.Recipe_Creation_Message)
                .build();
    }

    @Override
    public TasteBloomResponse updateRecipe(Long id, RecipeRequest recipeRequest) {
        Recipe existingRecipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));

        existingRecipe.setName(recipeRequest.getName());
        existingRecipe.setDescription(recipeRequest.getDescription());
        existingRecipe.setIngredients(recipeRequest.getIngredients());
        existingRecipe.setInstructions(recipeRequest.getInstructions());
        existingRecipe.setMealType(recipeRequest.getMealType());
        Recipe updatedRecipe = recipeRepository.save(existingRecipe);


        return TasteBloomResponse.builder()
                .responseCode(TasteBloomUtils.Recipe_Updated_Code)
                .responseMessage(TasteBloomUtils.Recipe_Updated_Message)
                .build();
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }


}
