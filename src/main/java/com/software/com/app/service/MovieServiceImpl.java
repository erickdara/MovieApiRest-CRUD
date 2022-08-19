package com.software.com.app.service;

import com.software.com.app.exception.ResourceNotFoundException;
import com.software.com.app.model.Movie;
import com.software.com.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {

        Optional<Movie> movieDb = this.movieRepository.findById(movie.getId());

        if (movieDb.isPresent()){
            Movie movieUpdate = movieDb.get();
            movieUpdate.setId(movie.getId());
            movieUpdate.setFilm(movie.getFilm());
            movieUpdate.setGenre(movie.getGenre());
            movieUpdate.setStudio(movie.getStudio());
            movieUpdate.setScore(movie.getScore());
            movieUpdate.setYear(movie.getYear());
            return movieUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + movie.getId());
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }


    @Override
    public Movie getMovieById(long movieId) {

        Optional<Movie> movieDb = this.movieRepository.findById(movieId);

        if (movieDb.isPresent()){
            return movieDb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + movieId);
        }
    }

    @Override
    public void deleteMovie(long movieId) {
        Optional<Movie> movieDb = this.movieRepository.findById(movieId);

        if(movieDb.isPresent()){
            this.movieRepository.delete(movieDb.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + movieId);
        }
    }
}
