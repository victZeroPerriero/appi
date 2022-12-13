package com.example.producer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class BookDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String nameBook;
    private String janr;
}
