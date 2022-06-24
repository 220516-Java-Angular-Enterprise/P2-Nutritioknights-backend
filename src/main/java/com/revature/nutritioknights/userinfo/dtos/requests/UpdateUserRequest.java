package com.revature.nutritioknights.userinfo.dtos.requests;

public class UpdateUserRequest {
    private String fname;
    private String lname;
    private int age;
    private String sex;
    private long height;
    private int targetCals;
    private String dietPlan_id;
    private long currentWeight;

    public UpdateUserRequest(){

    }

    public UpdateUserRequest(String fname, String lname, int age, String sex, long height, int targetCals, String dietPlan_id, long currentWeight) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.targetCals = targetCals;
        this.dietPlan_id = dietPlan_id;
        this.currentWeight = currentWeight;
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

    public String getDietPlan_id() {
        return dietPlan_id;
    }

    public void setDietPlan_id(String dietPlan_id) {
        this.dietPlan_id = dietPlan_id;
    }

    public long getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(long currentWeight) {
        this.currentWeight = currentWeight;
    }
}
