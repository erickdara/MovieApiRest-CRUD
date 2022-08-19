package com.software.com.app.controller;

import com.software.com.app.model.Movie;
import com.software.com.app.repository.MovieRepository;
import com.software.com.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/movie")
    public ResponseEntity<Movie> getProductById(@RequestParam long id){
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    @GetMapping(value = "/movies")
    @ResponseBody
    public ResponseEntity<List<Movie>> getAlphabeticalOrderedList(@RequestParam int total, @RequestParam String order) {
        Pageable paging = PageRequest.of(0, total, Sort.by(Sort.Direction.fromString(order)));
        Page<Movie> page = movieRepository.findAll(paging);
        return ResponseEntity.ok().body(page.getContent());
    }

    @PostMapping("/movie")
    public ResponseEntity<HashMap<String,String>> createMovie(@RequestBody Movie movie){
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "La película fue creada con éxito");
        return ResponseEntity.ok().body(map);
    }
}
