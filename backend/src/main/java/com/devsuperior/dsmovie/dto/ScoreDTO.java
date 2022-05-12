package com.devsuperior.dsmovie.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ScoreDTO {
    private Long movieId;
    private String email;
    private Double score;
}
