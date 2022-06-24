package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.dtos.requests.NewAvatarRequest;
import com.revature.nutritioknights.avatar.dtos.requests.UpdateAvatarRequest;
import com.revature.nutritioknights.userinfo.dtos.requests.UpdateUserRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avatars")
public class Avatar {

    @Id
    private String username;

    @Column(name = "gender")
    private String gender;

    @Column
    private String dietPlan_id;

    @Column(name = "level")
    private int level;

    @Column(name = "xp")
    private int xp;

    @Column
    private int attacks;

    public Avatar(){
    }

    public Avatar(String username, String gender, String dietPlan_id, int level, int xp, int attacks) {
        this.username = username;
        this.gender = gender;
        this.dietPlan_id = dietPlan_id;
        this.level = level;
        this.xp = xp;
        this.attacks = attacks;
    }

    public Avatar(NewAvatarRequest request) {
        this.username = request.getUsername();
        this.gender = request.getGender();
    }

    public Avatar(UpdateAvatarRequest request) {
        this.gender = request.getGender();
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getDietPlan_id() {
        return dietPlan_id;
    }

    public void setDietPlan_id(String dietPlan_id) {
        this.dietPlan_id = dietPlan_id;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }
}
