package com.polar.cape.demo.Repository;

import com.polar.cape.demo.Model.Author;
import com.polar.cape.demo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    //List<Book> findAllByAuthorLastname();

  /*  @Query(value = "select min(yearCreated) from book ")
    Book findMinYear();

    @Query(value = "select max(yearCreated) from book ")
    Book findMaxYear();*/

}
