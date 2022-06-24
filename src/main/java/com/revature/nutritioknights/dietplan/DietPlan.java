package com.revature.nutritioknights.dietplan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dietplans")
public class DietPlan {

    @Id
    private String id;

    @Column
    private String className;

    @Column(precision=3,scale = 2)
    private double protiens;

    @Column(precision=3,scale = 2)
    private double carbs;

    @Column(precision=3,scale = 2)
    private double fats;

    public DietPlan(){
    }

    public DietPlan(String id, String className, double protiens, double carbs, double fats) {
        this.id = id;
        this.className = className;
        this.protiens = protiens;
        this.carbs = carbs;
        this.fats = fats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getProtiens() {
        return protiens;
    }

    public void setProtiens(double protiens) {
        this.protiens = protiens;
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
}
