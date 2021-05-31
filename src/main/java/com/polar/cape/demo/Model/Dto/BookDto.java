package com.polar.cape.demo.Model.Dto;

import lombok.Data;

@Data
public class BookDto {

    String title;
    String ISBN;
    int yearCreated;

    public BookDto(String title, String ISBN, int yearCreated) {
        this.title = title;
        this.ISBN = ISBN;
        this.yearCreated = yearCreated;
    }
}
