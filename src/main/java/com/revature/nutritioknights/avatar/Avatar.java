package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.dtos.requests.NewAvatarRequest;
import com.revature.nutritioknights.avatar.dtos.requests.UpdateAvatarRequest;
import com.revature.nutritioknights.dietplan.DietPlan;
import com.revature.nutritioknights.level.Level;
import com.revature.nutritioknights.userinfo.dtos.requests.UpdateUserRequest;

import javax.persistence.*;

@Entity
@Table(name = "avatars")
public class Avatar {

    @Id
    private String username;

    @Column(name = "gender")
    private String gender;

    @OneToOne
    @JoinColumn(name = "level", referencedColumnName = "level")
    private Level level;

    @Column(name = "xp")
    private int xp;

    @Column
    private int attacks;

    public Avatar(){
    }



    public Avatar(NewAvatarRequest request) {
        this.username = request.getUsername();
        this.gender = request.getGender();
    }

    public Avatar(UpdateAvatarRequest request) {
        this.gender = request.getGender();
    }

    public Avatar(String username, String gender, Level level, int xp, int attacks) {
        this.username = username;
        this.gender = gender;
        this.level = level;
        this.xp = xp;
        this.attacks = attacks;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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
