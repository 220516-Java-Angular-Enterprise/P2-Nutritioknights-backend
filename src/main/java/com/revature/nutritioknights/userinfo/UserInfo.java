package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.userinfo.dtos.requests.NewUserInfoRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserInfo {

    @Id
    private String username;

    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname", nullable = false)
    private String lname;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "height")
    private long height;

    @Column(name = "targetCals")
    private int targetCals;

    @Column(name = "dietPlan")
    private String dietPlan;

    @Column(name= "currentWeight")
    private long currentWeight;


    public UserInfo(){

    }

    public UserInfo(String username, String user_id, String fname, String lname, int age, String sex, long height, int targetCals, String dietPlan, long currentWeight) {
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

    public UserInfo(NewUserInfoRequest request){
        this.username = request.getUsername();
        this.user_id = request.getUser_id();
        this.fname = request.getFname();
        this.lname = request.getLname();
        this.age = request.getAge();
        this.sex = request.getSex();
        this.height = request.getHeight();
        this.targetCals = request.getTargetCals();
        this.dietPlan = request.getDietPlan();
        this.currentWeight = request.getCurrentWeight();
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
