package com.revature.nutritioknights.signup.dtos.requests;

import com.revature.nutritioknights.login.UserCred;

public class NewCredRequest {
    private String username;
    private String password;
    private String email;
    private String role;

    public NewCredRequest(){
        super();
    }

    public NewCredRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public NewCredRequest(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserCred extractCred(){
        UserCred newUser = new UserCred();
        newUser.setUsername(this.username);
        newUser.setPassword(this.password);
        newUser.setEmail(this.email);
        newUser.setRole(this.role);
        return newUser;
    }
}
