package com.example.librarydemoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateDTO {
    private Integer id;
    private String title;
    private String authorName;
    private String description;
    private Integer quantity;
    private Integer cost;
}
