package com.gcinemaflix.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.model.RawMovie;
import com.gcinemaflix.utils.MovieListWrapper;

public interface RawMovieService {
	public List<RawMovie> getMovies();
	public RawMovie addMovie(RawMovie movie);
	public List<String> loadMoviesinDB(MovieListWrapper movies);
	public List<RawMovie> findByTitle(String Title);
	public List<RawMovie> findByType(String type);
	public List<RawMovie> findByYear(int year);
	public List<RawMovie> findbyGenre(String genre);
	public List<RawMovie> orderByRating();
	public List<RawMovie> orderByVotes();
	public List<RawMovie> orderByYear();
}
