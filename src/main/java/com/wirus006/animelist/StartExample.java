package com.wirus006.animelist;

import com.wirus006.animelist.entities.Anime;
import com.wirus006.animelist.repositories.AnimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartExample {

    private AnimeRepo animeRepo;

    @Autowired
    StartExample(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Anime anime = new Anime("Prince of tennis", "Completed");
        animeRepo.save(anime);
    }
}
