package com.devsuperior.dsmovie.services;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    private MovieDTO builder(Movie movie) {
        return MovieDTO.builder().id(movie.getId()).title(movie.getTitle()).score(movie.getScore())
                .count(movie.getCount()).image(movie.getImage()).build();
    }

    @Transactional
    public Page<MovieDTO> findall(Pageable pageable) {
        return movieRepository.findAll(pageable).map(item -> builder(item));
    }

    public MovieDTO findById(Long id){
        return builder(movieRepository.findById(id).get());
    }
}
