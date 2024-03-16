package com.coderscampus.Assignment9.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService{
	List<Recipe> recipes = new ArrayList<>();
	
	@Override
	public List<Recipe> ingestRecipe(){
		
		
		try {
			FileReader in = new FileReader("recipes.txt");
			Iterable<CSVRecord> records = CSVFormat.EXCEL
												   .withIgnoreSurroundingSpaces()
												   .withEscape('\\')
												   .withFirstRecordAsHeader()
												   .parse(in);
			for(CSVRecord csvRecord : records) {
				Recipe recipe = createRecipeFromFile(csvRecord);
				recipes.add(recipe);
			}
		} catch(IOException e) {
			System.out.println("Oops! Sorry, no file found");
		}
		return recipes;
		
	}

	@Override
	public List<Recipe> getGlutenFreeRecipes() {
		// TODO Auto-generated method stub
		return ingestRecipe().stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
	}

	@Override
	public List<Recipe> getVeganRecipes() {
		// TODO Auto-generated method stub
		return ingestRecipe().stream().filter(Recipe::getVegan).collect(Collectors.toList());
	}

	@Override
	public List<Recipe> getVegetarianRecipes() {
		// TODO Auto-generated method stub
		return ingestRecipe().stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
	}

	@Override
	public List<Recipe> getVeganAndGlutenFreeRecipes() {
		// TODO Auto-generated method stub
		return ingestRecipe().stream().filter(r -> r.getVegan() && r.getGlutenFree()).collect(Collectors.toList());
	}

	private Recipe createRecipeFromFile(CSVRecord csvRecord) {
		
		Recipe recipe = new Recipe();
		
		recipe.setCookingMinutes(Integer.parseInt(csvRecord.get("Cooking Minutes").trim()));
		recipe.setDairyFree(Boolean.parseBoolean(csvRecord.get("Dairy Free").trim()));
		recipe.setGlutenFree(Boolean.parseBoolean(csvRecord.get("Gluten Free").trim()));
		recipe.setInstructions(csvRecord.get("Instructions").trim());
		recipe.setPreparationMinutes(Double.parseDouble(csvRecord.get("Preparation Minutes").trim()));
		recipe.setPricePerServing(Double.parseDouble(csvRecord.get("Price Per Serving").trim()));
		recipe.setReadyInMinutes(Integer.parseInt(csvRecord.get("Ready In Minutes").trim()));
		recipe.setServings(Integer.parseInt(csvRecord.get("Servings").trim()));
		recipe.setSpoonacularScore(Double.parseDouble(csvRecord.get("Spoonacular Score").trim()));
		recipe.setTitle(csvRecord.get("Title").trim());
		recipe.setVegan(Boolean.parseBoolean(csvRecord.get("Vegan").trim()));
		recipe.setVegetarian(Boolean.parseBoolean(csvRecord.get("Vegetarian").trim()));
		
		return recipe;
		
	}
	
	
}
