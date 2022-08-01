package com.express.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.express.entity.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
	public List<Director> findByFirstNameAndLastName(String firstName,String lastName);
	
	@Query(value = "SELECT d.* FROM director d \r\n"
			+ "LEFT JOIN movie_director mv ON mv.director_id = d.director_id\r\n"
			+ "LEFT JOIN movie m ON m.movie_id = mv.movie_id\r\n"
			+ "WHERE m.movie_title = :movie_title", nativeQuery = true)
	@Transactional
	public List<Director> customGetDirectorByMovieName(@Param("movie_title") String movieTitle);

}
