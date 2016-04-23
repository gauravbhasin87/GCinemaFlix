package com.gcinemaflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gcinemaflix.model.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long>{

}
