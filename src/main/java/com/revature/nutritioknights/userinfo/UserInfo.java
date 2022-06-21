package com.revature.nutritioknights.userinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserInfo {

    @Id
    private String username;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname", nullable = false)
    private String lname;

    @Column(name = "dob")
    private Date dob;

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

    @Column(name= "targetWeight")
    private long targetWeight;

    public UserInfo(){

    }

    public UserInfo(String username, String fname, String lname, Date dob, int age, String sex, long height, int targetCals, String dietPlan, long currentWeight, long targetWeight) {
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.targetCals = targetCals;
        this.dietPlan = dietPlan;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public long getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(long targetWeight) {
        this.targetWeight = targetWeight;
    }
}
