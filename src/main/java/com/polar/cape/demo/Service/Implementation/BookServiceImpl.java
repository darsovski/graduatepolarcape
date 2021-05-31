package com.polar.cape.demo.Service.Implementation;

import com.polar.cape.demo.Model.Author;
import com.polar.cape.demo.Model.Book;
import com.polar.cape.demo.Model.Exceptions.BookNotFoundException;
import com.polar.cape.demo.Repository.BookRepository;
import com.polar.cape.demo.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> findAllByAuthorLastname(String s) {

        return this.bookRepository.findAll()
                .stream()
                .filter(x->x.getAuthor().getLastname().startsWith(s))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        Book book1 = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book1.setTitle(book.getTitle());
        book1.setYearCreated(book.getYearCreated());
        book1.setISBN(book.getISBN());
        book1.setAuthor(book.getAuthor());

        return Optional.of(this.bookRepository.save(book1));
    }

    @Override
    public List<String> findAllAuhtorsWithBooks() {

        List<Book> bookList = this.bookRepository.findAll();
        List<String> bookNameWithAuthors = new ArrayList<>();

        for (Book book : bookList) {
            bookNameWithAuthors.add(book.getAuthor() + " " + book.getTitle());
        }
        return bookNameWithAuthors;

/*        return this.bookRepository.findAll()
                .stream()
                .map(Book::getAuthor).collect(Collectors.toList());*/

    }

    @Override
    public List<String> allAuthorDecade() {

        List<String> authorsOfDecade = new ArrayList<>();

        List<Integer> yearCreatedBooks = this.bookRepository.findAll()
                .stream().map(Book::getYearCreated).collect(Collectors.toList());

        List<Author> dateOfBirthAuthors = this.bookRepository.findAll()
                .stream().map(Book::getAuthor).collect(Collectors.toList());
        List<String> yearOfBirthAuthors = new ArrayList<>();

        for(Author a : dateOfBirthAuthors) {
            String [] parts= a.getDateOfBirth().split(".");
            yearOfBirthAuthors.add(Integer.parseInt(parts[2]) +" " +  a.getName());
        }

        for(Integer i : yearCreatedBooks) {
            int decadeStart = yearCreatedBooks.get(i) - yearCreatedBooks.get(i)%10;
            int decadeEnd= decadeStart + 10;

            for (String author : yearOfBirthAuthors) {
                String [] part = author.split(" ");
                int year = Integer.parseInt(part[0]);
                String name = part[1];

                if (decadeStart>=year && decadeEnd<=year) {
                    authorsOfDecade.add(name);
                }
            }
        }
        return authorsOfDecade;
    }

    @Override
    public List<String> moreThan3Books() {
        List<Book> books = this.bookRepository.findAll();
        Map<String,Integer> maps=new HashMap<>();

        for(Book book : books) {
            maps.put(book.getAuthor().toString(),1);
        }

        for(String i : maps.keySet()) {
            maps.computeIfPresent(i,(key,value) -> ++value);
        }

        Iterator<Map.Entry<String,Integer>>  iterator = maps.entrySet().iterator();
        List<String> authorsNames=new ArrayList<>();

        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry = iterator.next();
            if(entry.getValue()>3) {
               // System.out.println(entry.getKey());
                authorsNames.add(entry.getKey());
            }
        }
        return authorsNames;
    }

    @Override
    public Book getOldestBook() {
        List<Book> books = this.bookRepository.findAll();
        Book book = books.stream()
                .min(Comparator.comparing(Book::getYearCreated)).get();

        return book;
    }

    @Override
    public Book getYoungestBook() {
        List<Book> books = this.bookRepository.findAll();
        Book book = books.stream()
                .max(Comparator.comparing(Book::getYearCreated)).get();

        return book;

       //return this.bookRepository.findMaxYear();
    }

    @Override
    public List<Book> getList() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

}
