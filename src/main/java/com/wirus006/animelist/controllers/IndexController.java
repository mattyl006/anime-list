package com.wirus006.animelist.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() {
        return "<h1> Hello Api </h1> <p> /animes/statusCount?status=# </p>";
    }
}
