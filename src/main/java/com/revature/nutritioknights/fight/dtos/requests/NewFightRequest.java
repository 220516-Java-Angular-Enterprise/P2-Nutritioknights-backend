package com.revature.nutritioknights.fight.dtos.requests;

public class NewFightRequest {
    private String username;
    private String monster_id;

    public NewFightRequest(){

    }

    public NewFightRequest(String username, String monster_id) {
        this.username = username;
        this.monster_id = monster_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(String monster_id) {
        this.monster_id = monster_id;
    }

}
