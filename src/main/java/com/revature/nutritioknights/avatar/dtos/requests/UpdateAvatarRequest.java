package com.revature.nutritioknights.avatar.dtos.requests;

public class UpdateAvatarRequest {
    private String gender;

    UpdateAvatarRequest(){

    }

    public UpdateAvatarRequest(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
