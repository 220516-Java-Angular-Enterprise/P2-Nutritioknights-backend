package com.revature.nutritioknights.fight;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.nutritioknights.avatar.Avatar;
import com.revature.nutritioknights.fight.dtos.requests.NewFightRequest;
import com.revature.nutritioknights.monster.Monster;
import com.revature.nutritioknights.userinfo.UserInfo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "fights")
public class Fight {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "monster_id", referencedColumnName = "id")
    private Monster monster_id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Avatar username;

    @Column
    private int fight_monster_hp;

    @Column
    private int fight_avatar_hp;

    @Column
    private long lastChecked;

    @Column
    private int monster_hits;

    @Column
    private boolean active;

    public Fight(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Monster getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(Monster monster_id) {
        this.monster_id = monster_id;
    }

    public Avatar getUsername() {
        return username;
    }

    public void setUsername(Avatar username) {
        this.username = username;
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

    public long getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(long lastChecked) {
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
