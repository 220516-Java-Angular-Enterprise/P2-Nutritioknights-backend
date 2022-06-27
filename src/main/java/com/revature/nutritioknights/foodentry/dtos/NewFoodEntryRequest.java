package com.revature.nutritioknights.foodentry.dtos;

import javax.persistence.Column;

public class NewFoodEntryRequest {

    private int mealname_id;

 //   private long dateInt;

    private long food_id;

    private long serving_id;

    private double serving_amt;
    private String username;

    public int getMealname_id() {
        return mealname_id;
    }

    public void setMealname_id(int mealname_id) {
        this.mealname_id = mealname_id;
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

    public double getServing_amt() {
        return serving_amt;
    }

    public void setServing_amt(double serving_amt) {
        this.serving_amt = serving_amt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NewFoodEntryRequest(int mealname_id, long food_id, long serving_id, double serving_amt, String username) {
        this.mealname_id = mealname_id;
        this.food_id = food_id;
        this.serving_id = serving_id;
        this.serving_amt = serving_amt;
        this.username = username;
    }
}
