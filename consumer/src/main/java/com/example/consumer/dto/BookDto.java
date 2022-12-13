package com.example.consumer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("id")
    private Long id;
    private String nameBook;
    private String janr;
}

