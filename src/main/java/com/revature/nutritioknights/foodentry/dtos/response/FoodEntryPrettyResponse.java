package com.revature.nutritioknights.foodentry.dtos.response;

public class FoodEntryPrettyResponse {

    private String entry_id;
    private double serving_amt;
    private String food;
    private double calories;
    private double protein;
    private double carbs;
    private double fats;
    private long food_id;
    private long serving_id;

    public FoodEntryPrettyResponse(String entry_id, double serving_amt, String food, double calories, double protein, double carbs, double fats,long food_id,long serving_id) {
        this.entry_id = entry_id;
        this.serving_amt = serving_amt;
        this.food = food;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.food_id=food_id;
        this.serving_id=serving_id;
    }

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public double getServing_amt() {
        return serving_amt;
    }

    public void setServing_amt(double serving_amt) {
        this.serving_amt = serving_amt;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public long getFood_id() {
        return food_id;
    }

    public void setFood_id(long food_id) {
        this.food_id = food_id;
    }

    public long getServing_id() {
        return serving_id;
    }

    public void setServing_id(long serving_id) {
        this.serving_id = serving_id;
    }
}
