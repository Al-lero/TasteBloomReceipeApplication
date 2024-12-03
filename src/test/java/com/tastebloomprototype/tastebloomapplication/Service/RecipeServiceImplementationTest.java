package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Data.Model.Recipe;
import com.tastebloomprototype.tastebloomapplication.Data.Repository.RecipeRepository;
import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
import com.tastebloomprototype.tastebloomapplication.MealType;
import com.tastebloomprototype.tastebloomapplication.utils.TasteBloomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceImplementationTest {

    private RecipeRequest recipeRequest;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    @BeforeEach
    public void setup() {
        recipeRequest = new RecipeRequest();
        recipeRequest.setName("Fluffy Pancakes");
        recipeRequest.setIngredients("Flour, Eggs, Milk, Sugar, Butter");
        recipeRequest.setDescription("1. Mix ingredients. 2. Cook on pan until golden brown.");
        recipeRequest.setMealType(MealType.RICE);

        recipeRepository.deleteAll();

    }

    @Test
    public void testUserCanCreateRecipe(){

        TasteBloomResponse response = recipeService.createRecipe(recipeRequest);

        assertEquals(TasteBloomUtils.Recipe_Created_Code, response.getResponseCode());
        assertEquals(TasteBloomUtils.Recipe_Creation_Message, response.getResponseMessage());

        Recipe savedRecipe = recipeRepository.findAll().get(0);
        assertNotNull(savedRecipe);
        assertEquals(recipeRequest.getName(), savedRecipe.getName());
        assertEquals(recipeRequest.getIngredients(), savedRecipe.getIngredients());
        assertEquals(recipeRequest.getInstructions(), savedRecipe.getInstructions());
        assertEquals(recipeRequest.getMealType(), savedRecipe.getMealType());

    }

    @Test
    public void testUserCanUpdateRecipe(){
        TasteBloomResponse createResponse = recipeService.createRecipe(recipeRequest);

        Recipe savedRecipe = recipeRepository.findAll().get(0);
        assertNotNull(savedRecipe);
        Long recipeId = savedRecipe.getId();

        RecipeRequest updatedRecipeRequest = new RecipeRequest();
        updatedRecipeRequest.setName("delicious pancakes");
        updatedRecipeRequest.setDescription("more delicious and fluffy");
        updatedRecipeRequest.setIngredients("updatedRecipeRequest.setIngredients(\"Flour, Eggs, Milk, Sugar, Butter, Vanilla");
        updatedRecipeRequest.setInstructions("1. Mix ingredients. 2. Cook on pan until golden brown. 3. Add syrup.");

        TasteBloomResponse updateResponse = recipeService.updateRecipe(recipeId, updatedRecipeRequest);

        assertEquals(TasteBloomUtils.Recipe_Updated_Code, updateResponse.getResponseCode());
        assertEquals(TasteBloomUtils.Recipe_Updated_Message, updateResponse.getResponseMessage());

        Recipe updatedRecipe = recipeRepository.findById(recipeId).orElse(null);
        assertNotNull(updatedRecipe);
        assertEquals(updatedRecipeRequest.getName(), updatedRecipe.getName());
        assertEquals(updatedRecipeRequest.getDescription(), updatedRecipe.getDescription());
        assertEquals(updatedRecipeRequest.getIngredients(), updatedRecipe.getIngredients());
        assertEquals(updatedRecipeRequest.getInstructions(), updatedRecipe.getInstructions());
        assertEquals(updatedRecipeRequest.getMealType(),updatedRecipe.getMealType());
    }

    @Test
    public void testUserCanViewAllRecipes() {

        recipeService.createRecipe(recipeRequest);
        List<Recipe> recipes = recipeService.getAllRecipes();

        assertNotNull(recipes);
        assertEquals(1, recipes.size());
        Recipe fetchedRecipe = recipes.get(0);
        assertEquals("Fluffy Pancakes", fetchedRecipe.getName());
        assertEquals("Flour, Eggs, Milk, Sugar, Butter", fetchedRecipe.getIngredients());
        assertEquals("1. Mix ingredients. 2. Cook on pan until golden brown.", fetchedRecipe.getDescription());
        assertEquals(MealType.RICE, fetchedRecipe.getMealType());

    }



}