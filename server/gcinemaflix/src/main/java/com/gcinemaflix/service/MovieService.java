package com.gcinemaflix.service;

import java.util.List;

import com.gcinemaflix.model.Movie;

public interface MovieService {

		public List<Movie> getMovies();
		public Movie addMovie(Movie movie);
	
}
