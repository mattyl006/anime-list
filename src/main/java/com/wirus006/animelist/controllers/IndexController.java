package com.wirus006.animelist.controllers;

import com.wirus006.animelist.entities.Anime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    String get(Model model) {
        Anime anime = new Anime("Prince of tennis", "Trans Arts", 2001, 178, "Completed");
        model.addAttribute("anime", anime);
        return "anime";
    }
}
