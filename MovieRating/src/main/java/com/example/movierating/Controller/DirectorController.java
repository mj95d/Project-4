package com.example.movierating.Controller;

import com.example.movierating.Model.Director;
import com.example.movierating.Service.ApplicationMovieDirector;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/director")
public class DirectorController {


    private final DirectorService directorService;


    @PostMapping("/get")
    public ResponseEntity getDirector(@RequestBody @Valid Director director) {
        return ResponseEntity.status(200).body(directorService.getDirector());
    }


    @GetMapping("/add")
    public ResponseEntity addDirector(@PathVariable String id) {
        directorService.addDirector(id);
        return ResponseEntity.status(200).body("add Director");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable String id, @RequestBody @Valid Director director) {
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body(" update Director");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable int id) {
        directorService.deleteDirector(id);
            return ResponseEntity.status(200).body("delete Director");
    }

}