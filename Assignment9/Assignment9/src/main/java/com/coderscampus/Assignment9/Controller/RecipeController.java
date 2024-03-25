package com.coderscampus.Assignment9.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.Recipe;
import com.coderscampus.Assignment9.Service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFreeRecipes(){
		return recipeService.getGlutenFreeRecipes();
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVegan(){
		return recipeService.getVeganRecipes();
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFree(){
		return recipeService.getVeganAndGlutenFreeRecipes();
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian(){
		return recipeService.getVegetarianRecipes();
	}
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes(){
		return recipeService.getAllRecipes();
	}
}
