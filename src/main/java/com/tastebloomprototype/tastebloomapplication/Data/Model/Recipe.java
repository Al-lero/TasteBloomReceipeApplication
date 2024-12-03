package com.tastebloomprototype.tastebloomapplication.Data.Model;

import com.tastebloomprototype.tastebloomapplication.MealType;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String ingredients;
    private String instructions;

    @Enumerated(EnumType.STRING)
    private MealType mealType;



}
