package com.gcinemaflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcinemaflix.model.RawMovie;

public interface RawMovieRepository extends JpaRepository<RawMovie,Integer>{
	
	public List<RawMovie> findByTitle(String title);
	public List<RawMovie> findByType(String type);
}
