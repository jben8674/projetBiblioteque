package com.Bengono.ProjetBiblioteque.service;


import com.Bengono.ProjetBiblioteque.model.Book;
import com.Bengono.ProjetBiblioteque.model.User;
import com.Bengono.ProjetBiblioteque.repository.BookRepository;
import com.Bengono.ProjetBiblioteque.repository.BorrowingRepository;
import com.Bengono.ProjetBiblioteque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BorrowingRepository BorrowingRepository;

private BookRepository bookRepository() {
    return bookRepository;
}

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findById(Long id) {

        return bookRepository.findById(id).get();
    }

    public Book findBookByTitle(String title) {

        return bookRepository.findByTitle(title);
    }
public List<Book> findByAuthor(String  author) {
    return bookRepository.findByAuthor(author);
}

public List<Book> findByCategory(String category) {
    return bookRepository.findByCategory(category);
}


    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id ,Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setCategory(book.getCategory());
            return bookRepository.save(bookToUpdate);
        }
        return null;




    }
}
