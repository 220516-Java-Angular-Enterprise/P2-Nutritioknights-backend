package com.revature.nutritioknights.level;

import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LevelService {

    @Inject
    private final LevelRepository  levelRepository;

    @Inject
    @Autowired
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public Level getByLevel(int level){
        return levelRepository.getByLevel(level);
    }
}
