package com.express.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.express.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByMovieTitle(String movieTitle);
	@Query(value = "SELECT m.* FROM movie m \r\n"
			+ "LEFT JOIN movie_director mv ON mv.movie_id = m.movie_id\r\n"
			+ "LEFT JOIN director d ON d.director_id = mv.director_id\r\n"
			+ "WHERE d.first_name = :first_name AND d.last_name = :last_name", nativeQuery = true)
	@Transactional
	public List<Movie> customGetMovieByDirectorName(@Param("first_name") String dirFirstName, @Param("last_name") String dirLastName);
}
