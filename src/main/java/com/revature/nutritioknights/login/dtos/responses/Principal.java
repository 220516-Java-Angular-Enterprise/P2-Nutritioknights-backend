package com.revature.nutritioknights.login.dtos.responses;

import com.revature.nutritioknights.login.UserCred;
import com.revature.nutritioknights.login.dtos.requests.LoginRequest;

public class Principal {
    private String id;
    private String email;
    private String role;

    public Principal() {
        super();
    }

    public Principal(String id, String username, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public Principal(UserCred userCred) {
        this.id = userCred.getId();
        this.email = userCred.getEmail();
        this.role = userCred.getRole();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Principal{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
