package com.devsuperior.dsmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieDTO {
    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;
}
