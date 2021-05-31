package com.polar.cape.demo.Model;
import com.polar.cape.demo.Model.Enumeration.BookType;

import javax.persistence.*;

@Entity(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String title;
    String ISBN;
    int yearCreated;

    @ManyToOne
    Author author;


    @Enumerated(EnumType.ORDINAL)
    BookType bookType;


    public Book(String title, String ISBN, int yearCreated,Author author,BookType BookType) {
        this.title = title;
        this.ISBN = ISBN;
        this.yearCreated = yearCreated;
        this.author=author;
        this.bookType=BookType;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
/*    public int compareTo(Book b) {
        int thisYear = (this).yearCreated;
        int anotherYear = b.yearCreated;
        return (thisYear<anotherYear ? -1 : (thisYear==anotherYear ? 0 : 1));
    }*/

    @Override
    public String toString() {
        return String.format("%s %s %d %s %s",title,ISBN,yearCreated,author,bookType);
    }
}
