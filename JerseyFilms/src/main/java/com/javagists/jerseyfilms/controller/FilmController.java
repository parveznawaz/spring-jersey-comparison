package com.javagists.jerseyfilms.controller;

import com.javagists.jerseyfilms.model.Film;
import com.javagists.jerseyfilms.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Collection;
import java.util.List;

@Component
@Path("/films")
public class FilmController {

	private static final Logger log = LoggerFactory.getLogger(FilmController.class);
	
	@Autowired
	FilmService fs;
	
	// API End-point to get a list of all films in the database
	@GET
	@Produces("application/json")
	public Collection<Film> films()
	{
		log.info("Executing film controller films");
		return fs.getAllFilms();
	}
	
	// API End-point to get a specific film by id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Film getFilm(@PathParam("id") String id) {
		log.info("Executing film controller films by id={}",id);
		return fs.getFilm(id);
	}

	@GET
	@Path("/genre/{genre}")
	@Produces("application/json")
	public Collection<Film> getFilmsByGenre(@PathParam("genre") String genre){
		log.info("films by genre={}",genre);
		return fs.getAllFilms();
	}


	@GET
	@Path("/searchByName")
	@Produces("application/json")
	public Collection<Film> searchByName(@QueryParam("name") String name){
		log.info("films by name={}",name);
		return fs.getAllFilms();
	}
	
	// API End-point to add a new film to database
	@POST
	@Consumes("application/json")
	public Response add(Film film, @Context UriInfo info) {
		fs.addFilm(film);
		return Response.created(URI.create(
				info.getAbsolutePath().toString()+"/"+film.getId()
				)).build();
	}
}