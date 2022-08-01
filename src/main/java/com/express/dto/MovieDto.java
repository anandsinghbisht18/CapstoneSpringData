package com.express.dto;

import java.time.LocalDate;

import com.express.entity.Movie;

public class MovieDto {

	Long movieId;
	String movieTitle;
	LocalDate dateReleased;
	LocalDate movieRunningTime;
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
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
	
	@Override
	public String toString() {
		return "MovieDto [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}
	
	public MovieDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieDto(String movieTitle, LocalDate dateReleased, LocalDate movieRunningTime) {
		super();
		this.movieTitle = movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}
}
