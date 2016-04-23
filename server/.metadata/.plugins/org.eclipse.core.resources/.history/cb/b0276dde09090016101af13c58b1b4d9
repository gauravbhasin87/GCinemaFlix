package com.gcinemaflix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.model.RawMovie;
import com.gcinemaflix.repository.RawMovieRepository;
import com.gcinemaflix.utils.MovieListWrapper;

@Service
public class RawMovieServiceImpl implements RawMovieService{

	@Autowired
	private RawMovieRepository rmovieRepository;
	@Override
	public List<RawMovie> getMovies() {
		// TODO Auto-generated method stub
		return rmovieRepository.findAll();
	}

	@Override
	public RawMovie addMovie(RawMovie movie) {
		// TODO Auto-generated method stub
		RawMovie existing = rmovieRepository.findByTitle(movie.getTitle());
		if(existing == null)
			return rmovieRepository.save(movie);
		else
			return null;
	}
	
	@Override
	public List<String> loadMoviesinDB(MovieListWrapper movies){
		
		List<String> response = new ArrayList<>();
		List<RawMovie> movielist = movies.getMovies();
		for(RawMovie movie : movielist){
				rmovieRepository.save(movie);
				response.add("Added Movie :    "+movie.getTitle());
		}
		return response;
	}

	@Override
	public RawMovie findByTitle(String Title) {
		// TODO Auto-generated method stub
		return rmovieRepository.findByTitle(Title);
	}

}
