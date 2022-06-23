package com.revature.nutritioknights.avatar.dtos.requests;

public class NewAvatarRequest {
    private String username;
    private String gender;

    public NewAvatarRequest(){

    }

    public NewAvatarRequest(String username, String gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
