package com.express.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.express.dto.MovieDto;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private long movieId;
	@Column(name = "movie_title" , length = 100)
	private String movieTitle;
	@Column(name = "date_released")
	private LocalDate dateReleased;
	@Column(name = "movie_runningTime")
	private LocalDate movieRunningTime;
	
	 @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinTable(name = "movie_director",
	 joinColumns = {@JoinColumn(name="movie_id")},
	 inverseJoinColumns = {@JoinColumn(name="director_id")}
	   )
	private Set<Director> directors = new HashSet<Director>();

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public LocalDate getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}

	public LocalDate getMovieRunningTime() {
		return movieRunningTime;
	}

	public void setMovieRunningTime(LocalDate movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public static void prepareMovieEntity(MovieDto movieDto) {
		// TODO Auto-generated method stub
		
	}
	
	
}
