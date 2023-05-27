package com.example.movierating.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "name cant be empty ")
    @Size(min= 2, message = "name must be longer than 2 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;


    @NotNull(message = "genre cant be empty")
    @Column(columnDefinition = "varchar(150) not null check (genre='drama' or genre='action' or genre='comedy')")
    private String genre;

    @Min(value = 0 )
    @Max(value = 12)
    @Column(columnDefinition = "int not null CHECK (rating > 0 and rating < 12)")
    @NotNull(message = "rating cant be empty")
    private Integer rating;

    @NotNull
    @Min(value = 60)
    @Column(columnDefinition = "varchar(20) not null unique")
    private Integer duration;

    @NotNull
    @Column(columnDefinition = "varchar(20) not null unique")
    private Long directorId;


}