package com.express.service;

import java.time.LocalDate;
import java.util.List;

import com.express.dto.DirectorDto;
import com.express.dto.MovieDto;
import com.express.entity.Movie;

public interface MovieService {
	public void addMovie(MovieDto movieDto,DirectorDto directorDto);
	public List<Movie> viewMovies();
	public String updateMovie(String movieTitle, LocalDate newRelasedate) throws Exception;
	public String updateDirector(String address, String firstName, String lastName)  throws Exception;
	public String removeMovie(String movieTitle) throws Exception;
	public List<MovieDto> displayMovieBasedonTitle(String movieTitle) throws Exception;
	public List<Movie> displayMovieBasedOnDirectorName(String firstName, String lastName) throws Exception;
}
