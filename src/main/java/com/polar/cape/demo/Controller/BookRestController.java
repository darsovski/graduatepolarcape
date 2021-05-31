package com.polar.cape.demo.Controller;


import com.polar.cape.demo.Model.Book;
import com.polar.cape.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/books")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/all")
    public List<Book> listAllBooks() {
        return this.bookService.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Book> save(@RequestBody Book book) {
            return this.bookService.save(book).map(book1 -> ResponseEntity.ok().body(book1))
                    .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping(value = "/edit/{id}")
    public Optional<Book> edit(@PathVariable Long id, Book book) {
        return this.bookService.edit(id,book);
    }

    @PostMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
            this.bookService.delete(id);
    }

    @PostMapping("/authors-books_name")
    public void findAllAuthorsWithBokName() {
        this.bookService.findAllAuhtorsWithBooks();
    }
}
