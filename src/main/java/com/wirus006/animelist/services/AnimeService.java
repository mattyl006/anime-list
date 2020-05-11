package com.wirus006.animelist.services;

import com.wirus006.animelist.entities.Anime;
import com.wirus006.animelist.repositories.AnimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private AnimeRepo animeRepo;

    @Autowired
    public AnimeService(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    public Iterable<Anime> listAllAnimePaging(Integer pageNr, Integer howManyOnPage) {
        return animeRepo.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    public Optional<Anime> findById(Long id) {
        return animeRepo.findById(id);
    }

    public Iterable<Anime> findAll() {
        return animeRepo.findAll();
    }

    public Anime save(Anime anime) {
        return animeRepo.save(anime);
    }

    public void deleteById(Long id) {
        animeRepo.deleteById(id);
    }

    public Boolean checkIfExist(Long id) {
        if (animeRepo.checkIfExist(id) > 0)
            return true;
        else return false;
    }

    public Long countByStatus(String status) {
        return animeRepo.countByStatus(status);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Anime("Prince of tennis", "Trans Arts", 2001, 178, "Completed"));
        save(new Anime("asd", "asd", 2020, 0, "Dropped"));
        save(new Anime("Prince of tennis2", "Trans Arts", 2002, 100, "Completed"));
    }
}
