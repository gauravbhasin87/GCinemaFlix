package com.gcinemaflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcinemaflix.model.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long>{

}
