package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_score")
public class Score {
    @EmbeddedId
    private ScorePK id = new ScorePK();
    private Double value;

    public void setMovie(Movie movie){
        id.setMovie(movie);
    }

    public void setUser(User user){
        id.setUser(user);
    }
}
