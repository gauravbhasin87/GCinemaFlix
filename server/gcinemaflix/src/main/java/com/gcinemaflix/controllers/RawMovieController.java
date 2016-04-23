package com.gcinemaflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.model.RawMovie;
import com.gcinemaflix.repository.GenreRepository;
import com.gcinemaflix.service.MovieService;
import com.gcinemaflix.service.RawMovieService;

@RestController
public class RawMovieController {

	@Autowired
	private RawMovieService movieService;
	@Autowired 
	GenreRepository genreRepository;
	
	@RequestMapping(value="/rawmovies", method=RequestMethod.GET)
	public List<RawMovie> getAllMovies(){
//	
		return movieService.getMovies();
	}
	
	
	
	@RequestMapping(value="/rawmovies",method=RequestMethod.POST)
	public RawMovie addMovie(@RequestBody RawMovie movie){
		//printMovie(movie);
		return movieService.addMovie(movie);
	}
	
	
	
	
}
