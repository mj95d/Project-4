package com.example.movierating.Controller;

import com.example.movierating.Model.Movie;
import com.example.movierating.Service.ApplicationMovieDirector;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {


    private final MovieService movieService;



    @GetMapping("/get")
    public ResponseEntity getMovie {
        return ResponseEntity.status(200).body(movieService.getMovies());
    }


    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie, Errors errors) {
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("add Movie");
    }


    @PostMapping("/update/movie/{id}")
    public ResponseEntity updateMovie(@PathVariable Long id, @RequestBody @Valid Movie movie) {
            movieService.deleteMovie(id);
            return ResponseEntity.status(200).body("delete Movie");
    }


    @DeleteMapping("/delete/movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) {
        return ResponseEntity.status(200).body("deleted");
    }



    @GetMapping("/title/search/{title}")
    public ResponseEntity searchTitle(@PathVariable String title ){
        return ResponseEntity.status(200).body(movieService.searchTitle(title));
    }

    @GetMapping("/duration/movie/{title}")
    public ResponseEntity getMovieDuration(@PathVariable String title ){
        return ResponseEntity.status(200).body(movieService.getMovieDuration(title));
    }

    @GetMapping("/movie/director/name/{title}")
    public ResponseEntity getMovieDirectorName(@PathVariable String title ){
        return ResponseEntity.status(200).body(movieService.getMovieDirectorName(title));
    }

    @GetMapping("/director/movie/{directorName}")
    public ResponseEntity getDirectorMovies(@PathVariable String directorName ){
        return ResponseEntity.status(200).body(movieService.getDirectorMovies(directorName));
    }

    @GetMapping("/movies/rating1/{t}")
    public ResponseEntity getMovieRating(@PathVariable String t ){
        return ResponseEntity.status(200).body(movieService.getMovieRating(t);
    }

    @GetMapping("/movies/rating2/{r}")
    public ResponseEntity getMoviesRating(@PathVariable Integer r ){
        return ResponseEntity.status(200).body(movieService.getMoviesWithHigherRating(r));
    }

    @GetMapping("/movies/genre/{g}")
    public ResponseEntity getMoviesGenre(@PathVariable String g){
        return ResponseEntity.status(200).body(movieDirectorService.getMoviesByGenre(g));
    }
}
