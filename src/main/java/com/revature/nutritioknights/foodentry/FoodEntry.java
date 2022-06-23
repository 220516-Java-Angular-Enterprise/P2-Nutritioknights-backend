package com.revature.nutritioknights.auth.foodentry;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "food_entries")
public class FoodEntry {
    @Id
    private String entry_id;

    //mealname is in ERD as an enum.  Need to decide if we define enum in postgresql or java, or just create a reference table
    //here it is defined as an enum
    enum mealname {
        BREAKFAST,AMSNACK,LUNCH,PMSNACK,SUPPER,NIGHTSNACK;
    }
    @Column(name = "meal_name")
    private mealname meal_name;

    @Column(name = "dateInt",nullable = false)
    private long dateInt;

    @Column(name = "food_id", nullable=false)
    private long food_id;

    @Column(name = "serving_id", nullable=false)
    private long serving_id;

    //this field is of type numeric(3,1) in database
    @Column(name = "serving_amt")
    private double serving_amt;

    //username is a foreign key to logins table
    @Column(name = "username", nullable = false)
    private String username;

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public mealname getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(mealname meal_name) {
        this.meal_name = meal_name;
    }

    public long getDateInt() {
        return dateInt;
    }

    public void setDateInt(long dateInt) {
        this.dateInt = dateInt;
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

    @Override
    public String toString() {
        return "Food_entry{" +
                "entry_id='" + entry_id + '\'' +
                ", meal_name=" + meal_name +
                ", dateInt=" + dateInt +
                ", food_id=" + food_id +
                ", serving_id=" + serving_id +
                ", serving_amt=" + serving_amt +
                ", username='" + username + '\'' +
                '}';
    }
}
