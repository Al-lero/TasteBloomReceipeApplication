package com.tastebloomprototype.tastebloomapplication.Dto.request;

import com.tastebloomprototype.tastebloomapplication.MealType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {
    private String name;
    private String description;
    private String ingredients;
    private String instructions;
    private MealType mealType;
}

