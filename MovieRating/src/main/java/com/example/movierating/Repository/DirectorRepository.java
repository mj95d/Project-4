package com.example.movierating.Repository;

import com.example.movierating.Model.Director;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface DirectorRepository extends JpaRepository<Director, Integer> {


    @Query
    List<Director> findByMoviesId(Id movieId);
    @Query
    List<Director> findByNameContaining(String name);

}