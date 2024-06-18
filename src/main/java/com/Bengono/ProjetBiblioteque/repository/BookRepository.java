package com.Bengono.ProjetBiblioteque.repository;

import com.Bengono.ProjetBiblioteque.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);

}








//public interface BookRepository extends JpaRepository<Book, Long> {
  //  Book findByAuthor(String authorName);
//}

//public interface BookRepository extends JpaRepository<Book, Long> {
 //   List<Book> findByCategory(String categoryName);
//}
