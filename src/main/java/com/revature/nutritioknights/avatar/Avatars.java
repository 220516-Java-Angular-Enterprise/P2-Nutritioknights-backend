package com.revature.nutritioknights.avatar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avatars {

    @Id
    private String username;

    @Column(name = "gender")
    private String gender;

    @Column(name = "avatarClass")
    private String avatarClass;

    @Column(name = "maxHP")
    private int maxHP;

    @Column(name = "level")
    private int level;

    @Column(name = "xp")
    private int xp;

    public Avatars(){
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

    public String getAvatarClass() {
        return avatarClass;
    }

    public void setAvatarClass(String avatarClass) {
        this.avatarClass = avatarClass;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
