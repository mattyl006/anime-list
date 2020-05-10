package com.wirus006.animelist.repositories;

import com.wirus006.animelist.entities.Anime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepo extends CrudRepository<Anime, Long> {
}
