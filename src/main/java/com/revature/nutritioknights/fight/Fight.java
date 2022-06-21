package com.revature.nutritioknights.fight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fight {

    @Id
    private String id;

    @Column
    private String monster_id;

    @Column
    private String avatar_id;

    @Column
    private int fight_monster_hp;

    @Column
    private int fight_avatar_hp;

    public Fight(){

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

    public String getAvatar_id() {
        return avatar_id;
    }

    public void setAvatar_id(String avatar_id) {
        this.avatar_id = avatar_id;
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
}
