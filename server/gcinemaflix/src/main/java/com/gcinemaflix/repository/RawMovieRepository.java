package com.gcinemaflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcinemaflix.model.RawMovie;

public interface RawMovieRepository extends JpaRepository<RawMovie,Integer>{

}
