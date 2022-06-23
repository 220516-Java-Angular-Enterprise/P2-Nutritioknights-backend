package com.revature.nutritioknights.fight;

import com.revature.nutritioknights.fight.dtos.requests.NewFightRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Fight {

    @Id
    private String id;

    @Column
    private String monster_id;

    @Column
    private String username;

    @Column
    private int fight_monster_hp;

    @Column
    private int fight_avatar_hp;

    @Column
    private Timestamp lastChecked;

    @Column
    private int monster_hits;

    @Column
    private boolean active;

    public Fight(){

    }

    public Fight(String id, String monster_id, String username, int fight_monster_hp, int fight_avatar_hp, Timestamp lastChecked, int monster_hits, boolean active) {
        this.id = id;
        this.monster_id = monster_id;
        this.username = username;
        this.fight_monster_hp = fight_monster_hp;
        this.fight_avatar_hp = fight_avatar_hp;
        this.lastChecked = lastChecked;
        this.monster_hits = monster_hits;
        this.active = active;
    }

    public Fight(NewFightRequest request) {
        this.monster_id = request.getMonster_id();
        this.username = request.getUsername();
        this.lastChecked = request.getLast_checked();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(String monster_id) {
        this.monster_id = monster_id;
    }


    public int getFight_monster_hp() {
        return fight_monster_hp;
    }

    public void setFight_monster_hp(int fight_monster_hp) {
        this.fight_monster_hp = fight_monster_hp;
    }

    public int getFight_avatar_hp() {
        return fight_avatar_hp;
    }

    public void setFight_avatar_hp(int fight_avatar_hp) {
        this.fight_avatar_hp = fight_avatar_hp;
    }

    public Timestamp getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Timestamp lastChecked) {
        this.lastChecked = lastChecked;
    }

    public int getMonster_hits() {
        return monster_hits;
    }

    public void setMonster_hits(int monster_hits) {
        this.monster_hits = monster_hits;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
