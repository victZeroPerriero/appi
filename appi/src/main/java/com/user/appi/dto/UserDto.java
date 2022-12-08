package com.user.appi.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("id")
    private Long id;
    private String firstName;
    private String lastName;
    private List<BookDto> bookDtoList;
}
