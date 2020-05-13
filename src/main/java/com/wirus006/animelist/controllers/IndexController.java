package com.wirus006.animelist.controllers;

import com.wirus006.animelist.entities.Anime;
import com.wirus006.animelist.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private AnimeService animeService;

    @Autowired
    public IndexController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    String get(Model model) {
        List<Anime> animes = (List<Anime>) this.animeService.findAll();
        model.addAttribute("animes", animes);
        return "anime";
    }
}
