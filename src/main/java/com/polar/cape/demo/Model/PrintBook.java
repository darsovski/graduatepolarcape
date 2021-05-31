package com.polar.cape.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "PRINTBOOK")
public class PrintBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    List<Book> book;

    int pages;
    float weight;

    public PrintBook(List<Book> book, int pages, float weight) {
        this.book=book;
        this.pages = pages;
        this.weight = weight;
    }
}
