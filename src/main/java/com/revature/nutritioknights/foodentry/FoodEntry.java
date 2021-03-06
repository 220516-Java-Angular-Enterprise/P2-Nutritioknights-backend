package com.revature.nutritioknights.foodentry;

import com.fatsecret.platform.model.Food;
import com.revature.nutritioknights.avatar.Avatar;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.mealnames.Mealname;
import com.revature.nutritioknights.userinfo.UserInfo;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "food_entries")
public class FoodEntry {
    @Id
    private String entry_id;


    @ManyToOne
    @JoinColumn(name = "mealname_id", referencedColumnName = "mealname_id")
    private Mealname mealname_id;

    @Column(name = "dateInt",nullable = false)
    private long dateInt;

    @Column(name = "food_id", nullable=false)
    private long food_id;

    @Column(name = "serving_id", nullable=false)
    private long serving_id;

    //this field is of type numeric(3,1) in database
    @Column(precision=3,scale=1,name = "serving_amt")
    private double serving_amt;

    //username is a foreign key to logins table
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserInfo username;

    public FoodEntry() {
    }

    public FoodEntry(NewFoodEntryRequest request) {
        Mealname mealname_id = new Mealname();
        mealname_id.setMealname_id(request.getMealname_id());
        this.mealname_id=mealname_id;
        this.food_id = request.getFood_id();
        this.serving_id = request.getServing_id();
        this.serving_amt = request.getServing_amt();
        UserInfo username = new UserInfo();
        username.setUsername(request.getUsername());
        this.username = username;
    }

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public int getMealname_id() {
        return mealname_id.getMealname_id();
    }

    public void setMealname_id(int mealname_id) {
        this.mealname_id.setMealname_id(mealname_id);
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
        return username.getUsername();
    }

    public void setUsername(String username) {
        UserInfo userinfo = new UserInfo();
        userinfo.setUsername(username);
        this.username = userinfo;
    }

    @Override
    public String toString() {
        return "Food_entry{" +
                "entry_id='" + entry_id + '\'' +
                ", mealname_id=" + mealname_id +
                ", dateInt=" + dateInt +
                ", food_id=" + food_id +
                ", serving_id=" + serving_id +
                ", serving_amt=" + serving_amt +
                ", username='" + username + '\'' +
                '}';
    }
}
