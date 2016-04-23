package com.gcinemaflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.repository.GenreRepository;
import com.gcinemaflix.repository.MovieRepository;
@Transactional
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private GenreRepository genreRepository;
	
	
	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Movie addMovie(Movie movie) {
		Movie created = movieRepository.save(movie);
		return created;
	}
	
}
