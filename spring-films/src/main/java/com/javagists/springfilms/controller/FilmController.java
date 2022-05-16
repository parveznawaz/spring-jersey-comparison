package com.javagists.springfilms.controller;

import com.javagists.springfilms.MvcConfig;
import com.javagists.springfilms.model.Film;
import com.javagists.springfilms.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/films")
public class FilmController {
    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    FilmService fs;

    // API End-point to get a list of all films in the database
    @GetMapping
    public Collection<Film> films() {
        logger.info("Get film called");
        return fs.getAllFilms();
    }

    // API End-point to get a specific film by id
    @GetMapping("/{id}")
    public Film getFilm(@PathVariable("id") String id) {
        return fs.getFilm(id);
    }

    // API End-point to add a new film to database
    @PostMapping
    public ResponseEntity add(Film film, HttpServletRequest info) {
        logger.info("Add film called");
        fs.addFilm(film);
        return ResponseEntity.created(URI.create(info.getContextPath())).build();
    }

    @GetMapping("/genre/{genre}")
    public Collection<Film> getFilmsByGenre(@PathVariable() String genre) {
        logger.info("Get films by genre={}",genre);
        return fs.getAllFilms();
    }

    @GetMapping("/searchByName")
    public Collection<Film> searchByName(@RequestParam String name){
        logger.info("films by name={}",name);
        return fs.getAllFilms();
    }

}
