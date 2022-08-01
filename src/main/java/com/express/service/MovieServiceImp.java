package com.express.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.dto.DirectorDto;
import com.express.dto.MovieDto;
import com.express.entity.Director;
import com.express.entity.Movie;
import com.express.repository.DirectorRepository;
import com.express.repository.MovieRepository;


@Service
public class MovieServiceImp implements MovieService{
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private DirectorRepository directorRepostory;
	@Override
	public void addMovie(MovieDto movieDto, DirectorDto directorDto) {
		
		Movie movie = new Movie();
		movie.setDateReleased(movieDto.getDateReleased());
		movie.setMovieRunningTime(movieDto.getMovieRunningTime());
		movie.setMovieTitle(movieDto.getMovieTitle());
		
		Director director = new Director();
		director.setAddress(directorDto.getAddress());
		director.setContact(directorDto.getContact());
		director.setEmail(directorDto.getEmail());
		director.setFirstName(directorDto.getFirstName());
		director.setLastName(directorDto.getLastName());
		
	// Add movie into director
		movie.getDirectors().add(director);
		movieRepository.save(movie); //we have use CASCADE_ALL 
		
	}
	@Override
	public List<Movie> viewMovies() {
		 return movieRepository.findAll();
	}
	
	@Override
	public String updateMovie(String movieTitle, LocalDate localDate) throws Exception { 
		List <Movie> m_list =  movieRepository.findByMovieTitle(movieTitle);
		if(!m_list.isEmpty()) {
		 for(Movie m1:m_list) {
			 m1.setDateReleased(localDate);
			 movieRepository.save(m1);
		 }
		 return "The Relase date for the movie with movie title :" + movieTitle + " has been updated successfully.";
		}else {
			Exception e = new Exception("invalid Movie.");
			return e.getMessage();
		}
	}
	@Override
	public String updateDirector(String address, String firstName, String lastName) throws Exception {
		List<Director> d_list = directorRepostory.findByFirstNameAndLastName(firstName,lastName);
		if(!d_list.isEmpty()) {
			 for(Director d1:d_list) {
				 d1.setAddress(address);
				 directorRepostory.save(d1);
			 }
			 return "The address for the director with director first name :" + firstName + " " + lastName + " has been updated successfully.";
			}else {
				Exception e = new Exception("invalid Director.");
				return e.getMessage();
			}
	}
	
	@Override
	@Transactional
	public String removeMovie(String movieTitle) throws Exception{
		List<Movie> m_list = movieRepository.findByMovieTitle(movieTitle);
		if(!m_list.isEmpty()) {
			for(Movie m1:m_list) {
				m1.getDirectors().removeAll(m1.getDirectors());
				movieRepository.delete(m1);
			}
			return "Remove movie based on movie title";
		}else {
			Exception e = new Exception("Movie with the given title is not present");
			return e.getMessage();
		}
	}
	@Override
	public List<MovieDto> displayMovieBasedonTitle(String movieTitle) throws Exception {
		 List<Movie> m_list = movieRepository.findByMovieTitle(movieTitle);
		 List<MovieDto> list=new ArrayList<MovieDto>();
		 if(!m_list.isEmpty()) {

			 for(Movie m1:m_list) {
				 MovieDto m = new MovieDto();
				 m.setDateReleased(m1.getDateReleased());
				 m.setMovieRunningTime(m1.getMovieRunningTime());
				 m.setMovieTitle(m1.getMovieTitle());
				 m.setMovieId(m1.getMovieId()); 
				 list.add(m);
			 }
		 }
		 return list;
	}
	public List<Movie> displayMovieBasedOnDirectorName(String dirFirstName, String dirLastName)  throws Exception {
		return movieRepository.customGetMovieByDirectorName(dirFirstName, dirLastName);
	}
	public List<Director> displayDirectorDetailsByMovieByName(String movieTitle)  throws Exception {
		return directorRepostory.customGetDirectorByMovieName(movieTitle);
	}
	
}
