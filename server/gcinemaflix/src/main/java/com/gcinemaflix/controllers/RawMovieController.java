package com.gcinemaflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.model.RawMovie;
import com.gcinemaflix.repository.GenreRepository;
import com.gcinemaflix.service.MovieService;
import com.gcinemaflix.service.RawMovieService;
import com.gcinemaflix.utils.MovieListWrapper;

@RestController
public class RawMovieController {

	@Autowired
	private RawMovieService movieService;
	@Autowired 
	GenreRepository genreRepository;
	
	@RequestMapping(value="/rawmovies", method=RequestMethod.GET)
	public ResponseEntity<List<RawMovie>> getAllMovies(){
		return new ResponseEntity<List<RawMovie>>(movieService.getMovies(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/admin/rawmovies",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<List<String>> loadMovies(@RequestBody MovieListWrapper movies){
		   MovieListWrapper m = movies;
			return new ResponseEntity<List<String>>(movieService.loadMoviesinDB(movies),HttpStatus.OK);
	}
	
	@RequestMapping(value="/admin/rawmovie",method=RequestMethod.POST)
	public ResponseEntity<RawMovie> addMovie(@RequestBody RawMovie movie){
		 List<RawMovie> existing = movieService.findByTitle(movie.getTitle());
		 if(existing == null || existing.size()==0){
			 return new ResponseEntity<>(movieService.addMovie(movie),HttpStatus.OK);
		 }
		 else
			 return new ResponseEntity<RawMovie>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/findMovieByTitle/{title}", method=RequestMethod.GET)
	public ResponseEntity<List<RawMovie>> findByTitle(@PathVariable String title){
		List<RawMovie> movies = movieService.findByTitle(title);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findMovieByType/{type}", method=RequestMethod.GET)
	public ResponseEntity<List<RawMovie>> findByType(@PathVariable String type){
		type = type.toLowerCase();
		List<RawMovie> movies = movieService.findByType(type);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findMovieByYear/{year}",method=RequestMethod.GET)
	public ResponseEntity<List<RawMovie>> findByYear(@PathVariable int year){
		List<RawMovie> movies = movieService.findByYear(year);
		return new ResponseEntity<>(movies,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findMovieByGenre/{genre}",method=RequestMethod.GET)
	public ResponseEntity<List<RawMovie>> findByGenre(@PathVariable String genre){
		List<RawMovie> movies = movieService.findbyGenre(genre);
		return new ResponseEntity<>(movies,HttpStatus.OK);
	}
	
}
