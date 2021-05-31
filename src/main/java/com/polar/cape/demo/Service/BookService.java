package com.polar.cape.demo.Service;

import com.polar.cape.demo.Model.Author;
import com.polar.cape.demo.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(Book book);
    List<Book> findAll();
    List<Book> findAllByAuthorLastname(String s);
    List<String> allAuthorDecade();
    List<String> moreThan3Books();
    Book getOldestBook();
    Book getYoungestBook();
    List<Book> getList();
    Optional<Book> save(Book book);
    Optional<Book> edit(Long id,Book book);
    List<String> findAllAuhtorsWithBooks();
    void delete(Long id);

}
