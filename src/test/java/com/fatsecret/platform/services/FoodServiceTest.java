package com.fatsecret.platform.services;
import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodServiceTest {
	private FatsecretService service;
	
	@Before
	public void setUp() {
        String key = "c0ae9b9890b142399dc76aa946f0cf72";
        String secret = "9b86932a34174edbacc079bff25fbf31";

        service = new FatsecretService(key, secret);
	}
	
	@Test
	public void testGetFood() {
		Food food = service.getFood(33691L);
		assertEquals("Colby Cheese", food.getName());
		assertEquals(7, food.getServings().size());
		assertEquals("Generic", food.getType());
	}
	@Test
	public void testGetFood2() {
		Food food = service.getFood(285243L);
		assertEquals("Penne", food.getName());
		assertEquals(4, food.getServings().size());
		assertEquals("Generic", food.getType());
	}

	@Test
	public void testGetFoodTypeGeneric() {
		Food food = service.getFood(285243L);
		assertEquals("Generic", food.getType());
	}

	@Test
	public void testGetFoodTypeBrand() {
		Food food = service.getFood(1844450L);
		assertEquals("Brand", food.getType());
	}
	@Test
	public void testSearchFoods(){
		Response<CompactFood> res = service.searchFoods("Colby cheese", 1);
		System.out.println("==>> Response");
		System.out.println("Total: " + res.getTotalResults());
		System.out.println("Max: " + res.getMaxResults());
		System.out.println("Size: " + res.getResults().size());
	}
}