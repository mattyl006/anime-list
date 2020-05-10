package com.wirus006.animelist.repositories;

import com.wirus006.animelist.entities.Anime;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepo extends CrudRepository<Anime, Long>, PagingAndSortingRepository<Anime, Long> {
    @Query("select count(a) from Anime a where a.id = ?1")
    Integer checkIfExist(Long id);

//    @Query("select count(a) from Anime a where a.status = ?1")
//    Integer showCountOfAnimeStatus(String status);

    Long countByStatus(String status);
}
