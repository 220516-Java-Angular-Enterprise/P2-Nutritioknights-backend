package com.revature.nutritioknights.mealnames;

import javax.persistence.*;
@Entity
@Table(name = "mealnames")
public class Mealname {
    @Id
    private int mealname_id;

    @Column(name = "mealname")
    private String mealname;

    public int getMealname_id() {
        return mealname_id;
    }

    public void setMealname_id(int mealname_id) {
        this.mealname_id = mealname_id;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public Mealname(int mealname_id, String mealname) {
        this.mealname_id = mealname_id;
        this.mealname = mealname;
    }

    public Mealname() {
    }

    @Override
    public String toString() {
        return "mealname{" +
                "mealname_id='" + mealname_id + '\'' +
                ", mealname='" + mealname + '\'' +
                '}';
    }
}
