package com.challenge.italiaonline.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArticoliBBCResponse implements Serializable {

    private String status;
    private Integer totalResults;
    private List<Articolo> articles;
}
