package com.wirus006.animelist.entities;

import javax.persistence.*;

@Entity
public class Anime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String studio;

    private Integer premiered;

    private Integer episodes;

    private String status;

    public Anime(){}

    public Anime(String title, String studio, Integer premiered, Integer episodes, String status) {
        this.title = title;
        this.studio = studio;
        this.premiered = premiered;
        this.episodes = episodes;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Integer getPremiered() {
        return premiered;
    }

    public void setPremiered(Integer premiered) {
        this.premiered = premiered;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
