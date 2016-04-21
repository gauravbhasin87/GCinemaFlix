package com.gcinemaflix.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	@Id
	@GeneratedValue
	@Column(name="movie_id")
	long id;
	String title;
	String year;
	String rated;
	Date released;
	String Director;
	String writers;
	String actors;
	String plot;
	String languages;
	String country;
	String awards;
	String poster;
	int metascore;
	float imdbRating;
	long imdbVotes;
	String imdbID;
	String type;
	
	@ManyToMany
	@JoinTable(name="movies_genres",
			joinColumns = @JoinColumn(name="movie_id"),
			inverseJoinColumns = @JoinColumn(name="genre_id" ))
	List<Genre> genres; 
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriters() {
		return writers;
	}
	public void setWriters(String writers) {
		this.writers = writers;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetascore() {
		return metascore;
	}
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	public long getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	long getId() {
		return id;
	}
	void setId(long movieId) {
		this.id = movieId;
	}
}
