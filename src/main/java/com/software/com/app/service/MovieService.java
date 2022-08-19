package com.software.com.app.service;

import com.software.com.app.model.Movie;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    List<Movie> getAllMovies();
    Movie getMovieById(long movieId);

    void deleteMovie(long id);

}
