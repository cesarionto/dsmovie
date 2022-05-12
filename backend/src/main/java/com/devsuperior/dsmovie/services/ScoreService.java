package com.devsuperior.dsmovie.services;

import java.util.Objects;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScoreService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        return preparaParaSalvar(scoreDTO);
    }

    private MovieDTO preparaParaSalvar(ScoreDTO scoreDTO) {
        User user = validaNovoUser(scoreDTO);
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
        builderScore(scoreDTO.getScore(), user, movie);
        atualizaMovie(movie);

        return MovieDTO.builder().id(movie.getId()).title(movie.getTitle()).score(movie.getScore())
        .count(movie.getCount()).image(movie.getImage()).build();
    }

    private User validaNovoUser(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (Objects.isNull(user))
            user = userRepository.saveAndFlush(User.builder().email(scoreDTO.getEmail()).build());
        return user;
    }

    private void atualizaMovie(Movie movie) {
        movie.setScore(calculaNovoScore(movie));
        movie.setCount(movie.getScores().size());

        movie = movieRepository.saveAndFlush(movie);
    }

    private double calculaNovoScore(Movie movie) {
        double sum = 0.0;
        for (Score scoreMovie : movie.getScores())
            sum = sum + scoreMovie.getValue();

        double avg = sum / movie.getScores().size();
        return avg;
    }

    private void builderScore(Double value, User user, Movie movie) {
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(value);
        score = scoreRepository.saveAndFlush(score);
    }

}
