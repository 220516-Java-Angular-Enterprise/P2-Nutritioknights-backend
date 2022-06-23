package com.revature.nutritioknights.monster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monsters")
public class Monster {

    @Id
    private String id;

    @Column
    private String monster_name;

    @Column
    private int monster_max_hp;

    @Column
    private int xp_given;

    @Column
    private int  attackPower;

    public Monster(){

    }

    public Monster(String id, String monster_name, int monster_max_hp, int xp_given, int attackPower) {
        this.id = id;
        this.monster_name = monster_name;
        this.monster_max_hp = monster_max_hp;
        this.xp_given = xp_given;
        this.attackPower = attackPower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonster_name() {
        return monster_name;
    }

    public void setMonster_name(String monster_name) {
        this.monster_name = monster_name;
    }

    public int getMonster_max_hp() {
        return monster_max_hp;
    }

    public void setMonster_max_hp(int monster_max_hp) {
        this.monster_max_hp = monster_max_hp;
    }

    public int getXp_given() {
        return xp_given;
    }

    public void setXp_given(int xp_given) {
        this.xp_given = xp_given;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
