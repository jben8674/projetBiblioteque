package com.Bengono.ProjetBiblioteque.repository;

import com.Bengono.ProjetBiblioteque.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
