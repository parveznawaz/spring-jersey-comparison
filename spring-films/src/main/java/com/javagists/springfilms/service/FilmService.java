package com.javagists.springfilms.service;

import com.javagists.springfilms.model.Film;
import com.javagists.springfilms.model.Genre;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class FilmService {
    private final ConcurrentMap<String, Film> db;

    public FilmService() {
        this.db = new ConcurrentHashMap<>();

        Film film1 = new Film();
        film1.setGenere(Genre.ACTION);
        film1.setId("1");
        film1.setName("Titanic");
        film1.setYear("1998");
        addFilm(film1);
    }

    // Get all the films stored in the database
    public Collection<Film> getAllFilms() {
        Collection<Film> all = this.db.values();
        if (all.isEmpty()) {
            return Collections.emptyList();
        } else {
            return all;
        }
    }
    // Add a film to database
    public void addFilm(Film f) {
        if(f.getId() == null) {
            f.setId(String.valueOf(this.db.size()+1));
        }
        this.db.put(f.getId(), f);
    }
    // Get a film by id
    public Film getFilm(String id) {
        return this.db.get(id);
    }
}