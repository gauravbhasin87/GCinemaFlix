package com.gcinemaflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcinemaflix.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
	
}
