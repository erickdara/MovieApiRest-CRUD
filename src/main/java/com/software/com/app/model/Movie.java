package com.software.com.app.model;

import javax.persistence.*;

@Entity
@Table(name = "peliculas")
public class Movie {

    @Id
    //@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 78, allocationSize = 500)
    //@GeneratedValue(generator = "mySeqGen")
    private Long id;

    @Column(name = "pelicula")
    private String film;

    @Column(name = "genero")
    private String genre;

    @Column(name = "estudio")
    private String studio;

    @Column(name = "puntaje")
    private String score;

    @Column(name = "anio")
    private String year;

    public Movie() {
    }

    public Movie(Long id, String film, String genre, String studio, String score, String year) {
        this.id = id;
        this.film = film;
        this.genre = genre;
        this.studio = studio;
        this.score = score;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
