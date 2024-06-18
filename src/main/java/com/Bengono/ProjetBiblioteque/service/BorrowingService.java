package com.Bengono.ProjetBiblioteque.service;

import com.Bengono.ProjetBiblioteque.model.Book;
import com.Bengono.ProjetBiblioteque.model.Borrowing;
import com.Bengono.ProjetBiblioteque.model.User;
import com.Bengono.ProjetBiblioteque.repository.BookRepository;
import com.Bengono.ProjetBiblioteque.repository.BorrowingRepository;
import com.Bengono.ProjetBiblioteque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BorrowingService(BorrowingRepository borrowingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.borrowingRepository = borrowingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public Borrowing findAllBorrowingById(Long id) {
        return borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));
    }

    public Borrowing createBorrowing(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Borrowing borrowing = new Borrowing();
        borrowing.setUser(user);
        borrowing.setBook(book);
        borrowing.setBorrowingDate(LocalDate.now());
        borrowing.setReturningDate(LocalDate.now().plusWeeks(2)); // example return date

        return borrowingRepository.save(borrowing);
    }

    public List<Borrowing> findAllBorrowing() {
        return borrowingRepository.findAll();
    }

    // Other methods...
}
