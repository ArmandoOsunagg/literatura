package com.alura.literatura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GutendexResponse {
    @JsonProperty("results")
    private List<LibroDto> results;

    // getters y setters


    public List<LibroDto> getResults() {
        return results;
    }

    public void setResults(List<LibroDto> results) {
        this.results = results;
    }

}
