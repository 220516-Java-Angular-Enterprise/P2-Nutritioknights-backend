package com.revature.nutritioknights.foodentry.dtos;

public class GetByDateRequest {
    private String username;
    private long dateInt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getDateInt() {
        return dateInt;
    }

    public void setDateInt(long dateInt) {
        this.dateInt = dateInt;
    }

    public GetByDateRequest(String username, long dateInt) {
        this.username = username;
        this.dateInt = dateInt;
    }
}
