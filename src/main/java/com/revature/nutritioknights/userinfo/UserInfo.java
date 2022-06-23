package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.userinfo.dtos.requests.NewUserInfoRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usersinfo")
public class UserInfo {

    @Id
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

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

    @Column(name = "dietPlan_id")
    private String dietPlan_id;

    @Column(name= "currentWeight")
    private long currentWeight;


    public UserInfo(){
    }

    public UserInfo(NewUserInfoRequest request){
        this.username = request.getUsername();
        this.email = request.getEmail();
        this.fname = request.getFname();
        this.lname = request.getLname();
        this.age = request.getAge();
        this.sex = request.getSex();
        this.height = request.getHeight();
        this.targetCals = request.getTargetCals();
        this.dietPlan_id = request.getDietPlan_id();
        this.currentWeight = request.getCurrentWeight();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", targetCals=" + targetCals +
                ", dietPlan_id='" + dietPlan_id + '\'' +
                ", currentWeight=" + currentWeight +
                '}';
    }
}
