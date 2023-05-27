package com.example.movierating.Repository;

import com.example.movierating.Model.Director;
import com.example.movierating.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query
    List<Movie> getMovieByDirectorId(Integer directorId);

    @Query
    List<Movie> findMovieById(String name);

    List<Movie> findByGenre(String genre);

    @Query
    List<Movie> getMovieById(double rating);

}


