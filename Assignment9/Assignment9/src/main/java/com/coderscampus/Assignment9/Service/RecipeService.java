package com.coderscampus.Assignment9.Service;

import java.util.List;

import com.coderscampus.Assignment9.Recipe;

public interface RecipeService {

	
	
	List<Recipe> getAllRecipes();
	List<Recipe> ingestRecipe();
	List<Recipe> getGlutenFreeRecipes();
	List<Recipe> getVeganRecipes();
	List<Recipe> getVegetarianRecipes();
	List<Recipe> getVeganAndGlutenFreeRecipes();
	
}
