package com.revature.nutritioknights.level;

import javax.persistence.*;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    private int level;

    @Column
    private int max_hp;

    @Column
    private int xp_ceiling;

    @Column
    private int xp_floor;

    @Column
    private int attackPower;

    public Level(){

    }

    public Level(int level, int max_hp, int xp_ceiling, int xp_floor, int attackPower) {
        this.level = level;
        this.max_hp = max_hp;
        this.xp_ceiling = xp_ceiling;
        this.xp_floor = xp_floor;
        this.attackPower = attackPower;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getXp_ceiling() {
        return xp_ceiling;
    }

    public void setXp_ceiling(int xp_ceiling) {
        this.xp_ceiling = xp_ceiling;
    }

    public int getXp_floor() {
        return xp_floor;
    }

    public void setXp_floor(int xp_floor) {
        this.xp_floor = xp_floor;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
