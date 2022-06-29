package com.revature.nutritioknights.monster;

import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonsterService {

    @Inject
    private final MonsterRepository monsterRepository;

    @Inject
    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Monster getMonsterByID(String id){
        return monsterRepository.getById(id);
    }

    public Optional<List<Monster>> getAllMonsters(){
        return monsterRepository.getAll();
    }


}
