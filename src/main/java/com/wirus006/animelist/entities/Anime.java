package com.wirus006.animelist.entities;

import javax.persistence.*;

@Entity
@Table(name = "Anime")
public class Anime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "studio")
    private String studio;

    @Column(name = "premiered")
    private Integer premiered;

    @Column(name = "episodes")
    private Integer episodes;

    @Column(name = "status")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
