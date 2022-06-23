package com.revature.nutritioknights.fight.dtos.requests;

import java.sql.Timestamp;

public class NewFightRequest {
    private String username;
    private String monster_id;
    private Timestamp last_checked;

    public NewFightRequest(){

    }

    public NewFightRequest(String username, String monster_id, Timestamp last_checked) {
        this.username = username;
        this.monster_id = monster_id;
        this.last_checked = last_checked;
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

    public Timestamp getLast_checked() {
        return last_checked;
    }

    public void setLast_checked(Timestamp last_checked) {
        this.last_checked = last_checked;
    }
}
