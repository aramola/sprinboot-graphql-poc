package com.poc.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private Integer id;
    private String author;
    private String title;
}
