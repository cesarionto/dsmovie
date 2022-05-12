package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/movies")
@AllArgsConstructor
public class MovieController {
    
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(movieService.findall(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findAll(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findById(id));
    }

}
