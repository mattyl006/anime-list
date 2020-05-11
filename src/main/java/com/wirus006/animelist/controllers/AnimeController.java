package com.wirus006.animelist.controllers;

import com.sun.istack.NotNull;
import com.wirus006.animelist.entities.Anime;
import com.wirus006.animelist.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class AnimeController {

    private AnimeService animeService;

    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    //basic operations

    @RequestMapping(value = "/animes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Anime> getAll() {
        return animeService.findAll();
    }

    @RequestMapping(value = "/animes/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Anime> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return animeService.listAllAnimePaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/anime/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Anime> getByPublicId(@PathVariable("id") Long publicId) {
        return animeService.findById(publicId);
    }

    @RequestMapping(value = "/anime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Anime> getById(@RequestParam Long index) {
        return animeService.findById(index);
    }

    @RequestMapping(value = "/anime", method = RequestMethod.POST)
    public ResponseEntity<Anime> addAnime(@RequestBody @Validated @NotNull Anime anime) {
        animeService.save(anime);
        return ResponseEntity.ok().body(anime);
    }

    @RequestMapping(value = "/anime", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAnime(@RequestBody @Validated @NotNull Anime anime) {
        if(!animeService.checkIfExist(anime.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            animeService.save(anime);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/animes", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Anime> redirect(Model model) {
        return animeService.findAll();
    }

    @RequestMapping(value = "/anime/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteAnime(HttpServletResponse response, @PathVariable Long id) {
        animeService.deleteById(id);
        return new RedirectView("/animes", true);
    }

    @RequestMapping(value = "/anime", method = RequestMethod.DELETE)
    public void deleteParamAnime(@RequestParam Long index) {
        animeService.deleteById(index);
    }

    //Endpointy statystyczne

    @RequestMapping(value = "/animes/statusCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long countByStatus(@RequestParam String status) {
        System.out.println(status);
        return animeService.countByStatus(status);
    }

}
