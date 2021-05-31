package com.polar.cape.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "EBOOK")
public class EBook  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    List<Book> book;

    String format;
    int size;

    public EBook(List<Book> book , String format , int size) {
        this.book=book;
        this.format = format;
        this.size = size;
    }
}
