package com.Bengono.ProjetBiblioteque.controller;

import com.Bengono.ProjetBiblioteque.model.Borrowing;
import com.Bengono.ProjetBiblioteque.service.BorrowingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping("/borrowings")
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.findAllBorrowing();
    }

    @GetMapping("/borrowings/{id}")
    public Borrowing getBorrowingById(@PathVariable Long id) {
        return borrowingService.findAllBorrowingById(id);
    }
    @PostMapping
    public Borrowing saveBorrowing(@RequestParam Long userId, @RequestParam Long bookId) {
        return borrowingService.createBorrowing(userId, bookId);
    }
}
