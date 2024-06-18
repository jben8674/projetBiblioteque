package com.Bengono.ProjetBiblioteque.controller;

import com.Bengono.ProjetBiblioteque.model.Book;
import com.Bengono.ProjetBiblioteque.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/new")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/update/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/findByTitle")
    public Book findByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);

    }
    @GetMapping("/findByAuthor")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }
    @GetMapping("/findByCategory")
    public List<Book> findBycategory(@RequestParam String category) {
        return bookService.findByCategory(category);
    }


}
