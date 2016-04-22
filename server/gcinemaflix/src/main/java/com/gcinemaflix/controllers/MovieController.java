package com.gcinemaflix.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcinemaflix.model.Genre;
import com.gcinemaflix.model.Movie;
import com.gcinemaflix.repository.GenreRepository;
import com.gcinemaflix.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@Autowired GenreRepository genreRepository;
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public List<Movie> getAllMovies(){
		List<Movie> list = new ArrayList<>();
		Movie m = new Movie();
		//m.setTitle("Ram Janey");
		List<Genre> list1 = new ArrayList<>();
		Genre rock = new Genre();
		rock.setName("Rock");
		list1.add(rock);
		
		//m.setGenres(list1);
		list.add(m);
		return list;
		
	}
	
	@RequestMapping(value="/movies",method=RequestMethod.POST)
	public Movie addMovie(@RequestBody Movie movie){
		//printMovie(movie);
		return movieService.addMovie(movie);
	}
	
	private static void printMovie(Movie movie){
		ObjectMapper mapper = new ObjectMapper();
		//Object to JSON in file
		try {
			mapper.writeValue(new File("c:\\file.json"), movie);
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Object to JSON in String
		try {
			String jsonInString = mapper.writeValueAsString(movie);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

