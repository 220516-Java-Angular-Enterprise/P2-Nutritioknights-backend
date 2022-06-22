package com.revature.nutritioknights.userinfo.dtos.requests;

import javax.persistence.Column;
import java.util.Date;

public class NewUserInfoRequest {

    private String username;
    private String user_id;
    private String fname;
    private String lname;
    private int age;
    private String sex;
    private long height;
    private int targetCals;
    private String dietPlan;
    private long currentWeight;

    public NewUserInfoRequest(){
        super();
    }

    public NewUserInfoRequest(String username, String user_id, String fname, String lname, int age, String sex, long height, int targetCals, String dietPlan, long currentWeight) {
        this.username = username;
        this.user_id = user_id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.targetCals = targetCals;
        this.dietPlan = dietPlan;
        this.currentWeight = currentWeight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public int getTargetCals() {
        return targetCals;
    }

    public void setTargetCals(int targetCals) {
        this.targetCals = targetCals;
    }

    public String getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(String dietPlan) {
        this.dietPlan = dietPlan;
    }

    public long getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(long currentWeight) {
        this.currentWeight = currentWeight;
    }
}
