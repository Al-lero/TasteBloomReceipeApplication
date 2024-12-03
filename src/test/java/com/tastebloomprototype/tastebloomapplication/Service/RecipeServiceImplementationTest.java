package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceImplementationTest {

    @Autowired
    private RecipeService recipeService;

    private RecipeRequest recipeRequest;

    @BeforeEach
    public void setup() {
        recipeRequest recipeRequest = new RecipeRequest();
        recipeRequest.setName("Pancakes");
        recipeRequest.setDescription("Delicious fluffy pancakes.");
        recipeRequest.setIngredients("Flour, Eggs, Milk, Sugar, Butter");
        recipeRequest.setInstructions("1. Mix ingredients. 2. Cook on pan until golden brown.");
        recipeRepository.deleteAll();
         }

}