package com.gcinemaflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gcinemaflix.model.RawMovie;

public interface RawMovieRepository extends JpaRepository<RawMovie,Integer>{
	
	public List<RawMovie> findByTitleIgnoreCase(String title);
	public List<RawMovie> findByTypeIgnoreCase(String type);
	public List<RawMovie> findByYear(int year);
	@Query("select m from RawMovie m where genre like %?1%")
	public List<RawMovie> findByGenre(String genre);
	public List<RawMovie> OrderByImdbRatingDesc();
	public List<RawMovie> OrderByImdbVotesDesc();
	public List<RawMovie> OrderByYearDesc();
}
