package com.gcinemaflix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.model.RawMovie;
import com.gcinemaflix.repository.RawMovieRepository;
import com.gcinemaflix.utils.MovieListWrapper;
@Transactional
@Service
public class RawMovieServiceImpl implements RawMovieService{

	@Autowired
	private RawMovieRepository rmovieRepository;
	@Override
	public List<RawMovie> getMovies() {
		return rmovieRepository.findAll();
	}

	@Override
	public RawMovie addMovie(RawMovie movie) {
		List<RawMovie> existing = rmovieRepository.findByTitleIgnoreCase(movie.getTitle());
		if(existing == null || existing.size()==0 )
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
	public List<RawMovie> findByTitle(String Title) {
		return rmovieRepository.findByTitleIgnoreCase(Title);
	}

	@Override
	public List<RawMovie> findByType(String type) {
		List<RawMovie> movies = rmovieRepository.findByTypeIgnoreCase(type);
		return movies;
	}

	@Override
	public List<RawMovie> findByYear(int year) {
		return rmovieRepository.findByYear(year);
	}

	@Override
	public List<RawMovie> findbyGenre(String genre) {
		return rmovieRepository.findByGenre(genre);
	}
	
	@Override
	public List<RawMovie> orderByRating(){
		return rmovieRepository.OrderByImdbRatingDesc(); 
	}

	@Override
	public List<RawMovie> orderByVotes() {
		return rmovieRepository.OrderByImdbVotesDesc();
	}

	@Override
	public List<RawMovie> orderByYear() {
		return rmovieRepository.OrderByYearDesc();
	}

}
