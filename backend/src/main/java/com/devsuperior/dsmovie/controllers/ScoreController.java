package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/scores")
@AllArgsConstructor
public class ScoreController {
    
    private ScoreService scoreService;

    @PutMapping
    public ResponseEntity<MovieDTO> findAll(@RequestBody ScoreDTO scoreDTO){
        return ResponseEntity.ok(scoreService.saveScore(scoreDTO));
    }

}
