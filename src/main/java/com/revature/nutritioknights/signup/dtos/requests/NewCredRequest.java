package com.revature.nutritioknights.signup.dtos.requests;

import com.revature.nutritioknights.login.UserCred;

public class NewCredRequest {
    private String email;
    private String password;
    private String role;

    public NewCredRequest(){
        super();
    }

    public NewCredRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public NewCredRequest(String username, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserCred extractCred(){
        UserCred newUser = new UserCred();
        newUser.setEmail(this.email);
        newUser.setPassword(this.password);
        newUser.setRole(this.role);
        return newUser;
    }
}
