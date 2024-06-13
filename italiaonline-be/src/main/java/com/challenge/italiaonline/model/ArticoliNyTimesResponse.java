package com.challenge.italiaonline.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArticoliNyTimesResponse implements Serializable {

    private String status;
    private String copyright;
    private Integer num_results;
    private List<Articolo> results;
}
