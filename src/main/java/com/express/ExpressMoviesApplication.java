package com.express;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.express.dto.DirectorDto;
import com.express.dto.MovieDto;
import com.express.service.MovieServiceImp;

@SpringBootApplication
@SuppressWarnings("unused")
public class ExpressMoviesApplication implements CommandLineRunner {
	@Autowired
	private MovieServiceImp movieService;
	public static void main(String[] args) {
		SpringApplication.run(ExpressMoviesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Movie DTO object
//    	MovieDto movieDto1 = new MovieDto("DDLJ",LocalDate.of(2010, 02, 27),LocalDate.of(2010, 02, 27));
		MovieDto movieDto2 = new MovieDto("Dhoom",LocalDate.of(2010, 02, 27),LocalDate.of(2010, 02, 27));
	    
    	//Director DTO object
//	    DirectorDto directorDto1 = new DirectorDto("Yash","RAJ","Pune",123456789,"abc1@gmail.com");
		DirectorDto directorDto2 = new DirectorDto("Shayam","RAJ","Pune",123456789,"abc2@gmail.com");
	    // saving..
//	    movieService.addMovie(movieDto2,directorDto2); //we have use CASCADE_ALL 
		
	    //Show all movies
//	    System.out.println(movieService.viewMovies());
		
//	    // Update new release date based on the movie title  
//	    System.out.println(movieService.updateMovie("Dhooms", LocalDate.of(2022, 8, 27)));
		
//		//Update director details based on director first and last name
//	    System.out.println(movieService.updateDirector("Delhi","Yash","RAJ")); 
	    //Remove movie based on movie title
//	    System.out.println(movieService.removeMovie("Dhoom"));
		
	    //get movies from movie title;
//	    System.out.println(movieService.displayMovieBasedonTitle("Dhoom"));
		
		//List movies based on director name
//		System.out.println(movieService.displayMovieBasedOnDirectorName("Yash","RAJ"));
		
		//List director's details based on the movie title
//		System.out.println(movieService.displayDirectorDetailsByMovieByName("Dhoom"));
	}
}
