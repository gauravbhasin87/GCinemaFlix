package com.gcinemaflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcinemaflix.model.Movie;
import com.gcinemaflix.model.RawMovie;
import com.gcinemaflix.repository.RawMovieRepository;

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
		return rmovieRepository.save(movie);
	}

}
