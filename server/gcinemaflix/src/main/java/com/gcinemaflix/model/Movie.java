package com.gcinemaflix.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="movies")
@JsonIgnoreProperties(ignoreUnknown = true) 
public class Movie {
	@Id
	@GeneratedValue
	@Column(name="movie_id")
	long id;
	@JsonProperty(value="Title")
	private String title;
	@JsonProperty(value="Year")
	private int year;
	
	@JsonProperty(value="Rated")
	String rated;
	@JsonProperty(value="Released")
	String released;			//should be Date?????????????
	@JsonProperty(value="RunTime")
	String runTime;
	@JsonProperty(value="Director")
	String director;
	@JsonProperty(value="Writer")
	String writers;
	@JsonProperty(value="Actors")
	String actors;
	@JsonProperty(value="Plot")
	String plot;
	@JsonProperty(value="Language")
	String language;
	@JsonProperty(value="Country")
	String country;
	@JsonProperty(value="Awards")
	String awards;
	@JsonProperty(value="Poster")
	String poster;
	@JsonProperty(value="Metascore")
	int metascore; 
	@JsonProperty(value="imdbRating")
	float imdbRating;
	@JsonProperty(value="imdbVotes")
	String imdbVotes;
	String imdbID;
	@JsonProperty(value="Type")
	String type;
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="movies_genres",
			joinColumns = @JoinColumn(name="movie_id"),
			inverseJoinColumns = @JoinColumn(name="genre_id" ))
	@JsonProperty(value="Genre")
	List<Genre> genres = new ArrayList<>(); 
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
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
	
	
	
}
