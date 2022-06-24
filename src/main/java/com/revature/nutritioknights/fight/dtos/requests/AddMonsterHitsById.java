package com.revature.nutritioknights.fight.dtos.requests;

public class AddMonsterHitsById {
    private int monster_hits;

    public AddMonsterHitsById(){

    }
    public AddMonsterHitsById(int monster_hits) {
        this.monster_hits = monster_hits;
    }

    public int getMonster_hits() {
        return monster_hits;
    }

    public void setMonster_hits(int monster_hits) {
        this.monster_hits = monster_hits;
    }
}
