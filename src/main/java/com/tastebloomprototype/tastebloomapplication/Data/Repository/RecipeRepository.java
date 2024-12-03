package com.tastebloomprototype.tastebloomapplication.Data.Repository;

import com.tastebloomprototype.tastebloomapplication.Data.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository  extends JpaRepository<Recipe, Long> {

}
