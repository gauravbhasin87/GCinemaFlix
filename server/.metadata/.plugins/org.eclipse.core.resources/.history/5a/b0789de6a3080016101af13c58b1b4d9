package com.gcinemaflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie addMovie(@RequestBody Movie movie) {
		Movie created = movieRepository.save(movie);
		return created;
	}
	
}
