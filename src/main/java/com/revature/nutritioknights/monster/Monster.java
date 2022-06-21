package com.revature.nutritioknights.monster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Monster {

    @Id
    private String id;

    @Column
    private String monster_name;

    @Column
    private String monster_pic;

    @Column
    private int monster_max_hp;
}
