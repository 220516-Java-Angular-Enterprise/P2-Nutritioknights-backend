package com.revature.nutritioknights.foodentry.dtos;

public class GetByMealnameRequest {
    private int mealname_id;

    private String username;
    public int getMealnameId() {
        return mealname_id;
    }

    public void setMealnameId(int mealname) {
        this.mealname_id = mealname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GetByMealnameRequest(int mealname, String username) {
        this.mealname_id = mealname;
        this.username = username;
    }
}
