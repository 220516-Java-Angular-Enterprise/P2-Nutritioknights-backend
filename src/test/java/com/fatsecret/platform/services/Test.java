package com.fatsecret.platform.services;

import com.fatsecret.platform.model.*;

import java.util.List;

public class Test {

	public static void main(String[] args) {
        String key = "c0ae9b9890b142399dc76aa946f0cf72";
        String secret = "9b86932a34174edbacc079bff25fbf31";

        FatsecretService service = new FatsecretService(key, secret);
        service.getRecipe(315L);
        service.searchRecipes("Marinated Herb Chicken");

		Response<CompactRecipe> response = service.searchRecipes("chicken");

		System.out.println("Total Results: " + response.getTotalResults());
		System.out.println("Max Results: " + response.getMaxResults());
		System.out.println("Page Number: " + response.getPageNumber());
		List<CompactRecipe> list = response.getResults();

		int i = 1;
		for(CompactRecipe recipe : list) {
			System.out.println(response.getMaxResults()*response.getPageNumber()+i + ": " + recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
			i++;
		}
		response = service.searchRecipes("chicken",1);

		System.out.println("Total Results: " + response.getTotalResults());
		System.out.println("Max Results: " + response.getMaxResults());
		System.out.println("Page Number: " + response.getPageNumber());

		list = response.getResults();

		i = 1;
		for(CompactRecipe recipe : list) {
			System.out.println(response.getMaxResults()*response.getPageNumber()+i + ": " + recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
			i++;
		}

		System.out.println("==================================================================================================================================");
		Recipe recipe = service.getRecipe(84411L);
		System.out.println(recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
		System.out.println("Prep Time: " + recipe.getPreparationTime() + ", Cook Time: " + recipe.getCookingTime());

		System.out.println("==>> Directions");

		for(Direction direction: recipe.getDirections()) {
			System.out.println(direction.getNumber() + " - " + direction.getDescription());
		}

		System.out.println("==>> Ingredients");

		for(Ingredient ingredient: recipe.getIngredients()) {
			System.out.println(ingredient.getName() + " - " + ingredient.getNumberOfUnits() + " " + ingredient.getMeasurementDescription());
		}

		Food food = service.getFood(60810L);
		System.out.println("==>> Food");
		System.out.println("Food: " + food.getName());

	}
}